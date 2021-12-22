package com.tauhidizzan.pencatatstok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToStokBarangList()
    }
    private fun changePageFragment(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)
        transaction.commit()
    }
    fun goToStokBarangList() {
        changePageFragment(supportFragmentManager, StokBarangFragment.newInstance(),
            R.id.fragmentContent)
    }
    fun goToAddStokBarang(){
        changePageFragment(supportFragmentManager, StokBarangAddFragment.newInstance(),
            R.id.fragmentContent)

    }

    fun goToBiodata(){
        changePageFragment(supportFragmentManager, BiodataFragment.newInstance(),
            R.id.fragmentContent)

    }
}