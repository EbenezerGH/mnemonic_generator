package jfyg.mnemonic.generator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.app_bar_main.*

class Bip44Fragment : HomeFragment() {
    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity.toolbar.title = "bip44"

        val view = inflater?.inflate(R.layout.fragment_bip44, container, false)
        return view
    }

}