package jfyg.mnemonic.generator

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.app_bar_main.*


open class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity.toolbar.title = "home"

        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        return view
    }

}