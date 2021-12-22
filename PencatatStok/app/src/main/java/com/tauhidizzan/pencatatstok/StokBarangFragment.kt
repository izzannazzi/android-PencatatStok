package com.tauhidizzan.pencatatstok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_stok_barang_list.*

class StokBarangFragment : Fragment() {
    companion object {
        fun newInstance(): StokBarangFragment {

            return StokBarangFragment()
        }
    }
    private var stokList : List<StokBarang>? = null
    private var db: RoomDatabases.AppDatabase? = null
    private var stokBarangDao: StokBarangDao? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_stok_barang_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }
    private fun initLocalDB() {
        db = RoomDatabases.AppDatabase.getAppDataBase(requireActivity())
        stokBarangDao = db?.myFriendDao()
    }
    private fun initView() {
        addStokBarang.setOnClickListener { (activity as
                MainActivity).goToAddStokBarang() }
        biodata.setOnClickListener { (activity as
                MainActivity).goToBiodata() }
        getStokBarangData()
    }
    private fun getStokBarangData() {
        stokList = ArrayList()
        stokBarangDao?.getStokBarang()?.observe(viewLifecycleOwner, Observer { r ->
            stokList = r
            when {
                stokList?.size == 0 -> showToast("Belum ada data teman")
                else -> {
                    showStokBarang()
                }
            }
        })
    }
    private fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }
    private fun showStokBarang() {
        stokBarangList.layoutManager = LinearLayoutManager(activity)
        stokBarangList.adapter = StokBarangAdapter(requireActivity(), stokList!!)
    }
    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}