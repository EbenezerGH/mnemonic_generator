package jfyg.mnemonic.generator

import android.os.Bundle

class MainActivity : NavigationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initMainFragment()
    }

    private fun initMainFragment() {
        val fm = fragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            fragment = HomeFragment()
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }

}

/*
*         //TODO: handle fragment backstack properly
*         //TODO: remove all hardcoded strings
*         //TODO: setup MVP framework
*         //TODO: write tests
*
*
* */