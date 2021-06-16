package org.d3if4131.magang.histori

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3if4131.magang.R
import org.d3if4131.magang.data.BarangHt
import org.d3if4131.magang.databinding.ItemHistoriBinding
import org.d3if4131.magang.db.BarangEntity

class HistoriAdapter : RecyclerView.Adapter<HistoriAdapter.ViewHolder>() {
    private val data = mutableListOf<BarangEntity>()
    fun updateData(newData: List<BarangEntity>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoriAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoriAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BarangEntity) = with(binding) {
            val jumlahBarang = BarangHt.hitung(item)
            hasilTV.text = jumlahBarang.jumlah.toString()
            bawangTv.text = root.context.getString(R.string.Bawang_x, item.bawang)
            kobisTv.text = root.context.getString(R.string.Kobis_x, item.kobis)
        }
    }
}