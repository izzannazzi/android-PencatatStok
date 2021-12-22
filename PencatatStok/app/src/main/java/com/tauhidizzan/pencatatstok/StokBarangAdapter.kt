package com.tauhidizzan.pencatatstok

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_stok_barang_list.*

import kotlinx.android.synthetic.main.item_stok_barang.*

class StokBarangAdapter (private val context: Context, private val items:
        List<StokBarang>) :
RecyclerView.Adapter<StokBarangAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_stok_barang,
                parent, false
            )
        )
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }
    override fun getItemCount(): Int = items.size
    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: StokBarang) {
            txtKodeBarang.text = item.kodeBarang
            txtNamaBarang.text = item.namaBarang
            txtJmlStok.text = item.jmlStok.toString()
            txtHpp.text = item.hppBarang.toString()
            txtHargaJual.text = item.hargaJual.toString()
        }

    }
}