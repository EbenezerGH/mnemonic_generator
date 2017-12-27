package jfyg.mnemonic.generator.bip39

import io.github.novacrypto.bip32.PrivateKey
import io.github.novacrypto.bip39.WordList
import io.github.novacrypto.bip39.Words

interface Bip39Presenter {

    fun retrievePublicKeyAddresses(root: PrivateKey, numberOfKeys: Int)
    fun generateRootKey(words: Words, passphrase: String, language: WordList): PrivateKey
    fun generateBIP44Addresses(root: PrivateKey) //todo: decide where to put this
    fun generateNewMnemonic(wordCount: Words, language: WordList): String
}