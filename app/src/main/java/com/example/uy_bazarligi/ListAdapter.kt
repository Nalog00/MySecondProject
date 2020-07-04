package com.example.uy_bazarligi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun populateModel(bazarliq: Bazarliq){
            itemView.tvAti.text = bazarliq.nameQq
            itemView.tvSI.text = bazarliq.olshemBirlik
            itemView.tvSumma.text = bazarliq.summa
            itemView.btnOptions.setOnClickListener {
            }
        }
    }

    var models: List<Bazarliq> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
      val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }
}