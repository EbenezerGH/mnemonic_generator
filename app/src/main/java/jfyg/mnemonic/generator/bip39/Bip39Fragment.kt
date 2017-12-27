package jfyg.mnemonic.generator.bip39

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import jfyg.mnemonic.generator.HomeFragment
import jfyg.mnemonic.generator.R
import kotlinx.android.synthetic.main.fragment_bip39.num_of_words_sb


class Bip39Fragment : HomeFragment() {
    private lateinit var presenter: Bip39Presenter

    var seekBar: SeekBar = num_of_words_sb

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_bip39, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        // val root = generateRootKey(Words.TWELVE, "", French.INSTANCE)
        // generateBIP44Addresses(root) //todo: Decide if this needs to be thrown in presenter
        // retrievePublicKeyAddresses(root, 20)
        */
        presenter = Bip39PresenterImpl()
    }

}