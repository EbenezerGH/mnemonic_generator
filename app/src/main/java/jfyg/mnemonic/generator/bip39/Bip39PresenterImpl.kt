package jfyg.mnemonic.generator.bip39

import android.util.Log
import io.github.novacrypto.bip32.Index
import io.github.novacrypto.bip32.PrivateKey
import io.github.novacrypto.bip32.networks.Bitcoin
import io.github.novacrypto.bip39.MnemonicGenerator
import io.github.novacrypto.bip39.SeedCalculator
import io.github.novacrypto.bip39.WordList
import io.github.novacrypto.bip39.Words
import io.github.novacrypto.bip44.Account
import io.github.novacrypto.bip44.AddressIndex
import io.github.novacrypto.bip44.BIP44
import java.security.SecureRandom

class Bip39PresenterImpl : Bip39Presenter {
    override fun retrievePublicKeyAddresses(root: PrivateKey, numberOfKeys: Int) {
        val account = BIP44.m().purpose44()
                .coinType(1)
                .account(0)
        val accountKey = root.derive(account, Account.DERIVATION)
                .neuter()

        val external = account.external()

        for (i in 0..numberOfKeys) {
            val derivationPath = external.address(i)
            val publicKey = accountKey.derive(derivationPath, AddressIndex.DERIVATION_FROM_ACCOUNT)
            Log.i("BIP44 Addresses II: ", derivationPath.toString() + " = " + publicKey.p2pkhAddress())
        }
    }

    override fun generateRootKey(words: Words, passphrase: String, language: WordList): PrivateKey {
        val generator: String = generateNewMnemonic(words, language)
        val seed = SeedCalculator().calculateSeed(generator, passphrase)
        return PrivateKey.fromSeed(seed, Bitcoin.TEST_NET) //TODO Test Network or Main Network?
    }

    override fun generateBIP44Addresses(root: PrivateKey) {
        root.cKDpriv(Index.hard(44)) //fixed
                .cKDpriv(Index.hard(1)) //bitcoin testnet coin
                .cKDpriv(Index.hard(0)) //account =1
                .cKDpriv(0) //external
                .cKDpriv(0) //first address
                .neuter().p2pkhAddress()
    }

    override fun generateNewMnemonic(wordCount: Words, language: WordList): String {
        val sb = StringBuilder()
        val entropy = ByteArray(wordCount.byteLength())
        SecureRandom().nextBytes(entropy)
        MnemonicGenerator(language)
                .createMnemonic(entropy, ({ sb.append(it) }))
        return sb.toString()
    }

}