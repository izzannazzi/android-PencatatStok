package com.tauhidizzan.pencatatstok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_input_stok.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
class StokBarangAddFragment : Fragment() {
    companion object {
        fun newInstance(): StokBarangAddFragment {

            return StokBarangAddFragment()
        }
    }
    private var kodeBarang : String = ""
    private var namaBarang : String = ""
    private var jmlStokBarang : Int = 0
    private var hppBarang : Int = 0
    private var hargaJual : Int = 0
    private var db: RoomDatabases.AppDatabase? = null
    private var stokBarangDao: StokBarangDao? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_input_stok, container, false)
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
        btn_input_brg.setOnClickListener { validasiInput() }
    }

    private fun validasiInput() {
        namaBarang = nama_barang.text.toString()
        kodeBarang = kode_barang.text.toString()
        jmlStokBarang = Integer.parseInt(jumlah_stok.text.toString())
        hppBarang = Integer.parseInt(harga_pokok.text.toString())
        hargaJual = Integer.parseInt(harga_jual.text.toString())
        when{
            namaBarang.isEmpty() -> nama_barang.error = "Nama Barang tidak boleh kosong"
            kodeBarang.isEmpty() -> kode_barang.error = "Kode Barang tidak boleh kosong"
            jmlStokBarang.equals(null) -> jumlah_stok.error = "Jumlah Stok tidak boleh kosong"
            hppBarang.equals(null) -> harga_pokok.error = "Harga Pokok tidak boleh kosong"
            hargaJual.equals(null) -> harga_jual.error = "Harga Jual tidak boleh kosong"
            else -> {
                val stok = StokBarang(namaBarang = namaBarang, kodeBarang = kodeBarang, jmlStok =
                jmlStokBarang, hppBarang = hppBarang, hargaJual = hargaJual)

                addStokBarang(stok)
            }
        }
    }
    private fun addStokBarang(stokBarang: StokBarang) : Job {
        return GlobalScope.launch {
            stokBarangDao?.addStokBarang(stokBarang)
            (activity as MainActivity).goToStokBarangList()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}