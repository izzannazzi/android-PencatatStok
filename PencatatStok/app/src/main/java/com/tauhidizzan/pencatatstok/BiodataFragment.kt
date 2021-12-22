package com.tauhidizzan.pencatatstok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class BiodataFragment : Fragment() {
    companion object {
        fun newInstance(): BiodataFragment {

            return BiodataFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.biodata, container, false)
    }
}
