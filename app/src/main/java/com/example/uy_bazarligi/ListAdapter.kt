package com.example.uy_bazarligi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jerglikOnim.data.model.Product
import kotlinx.android.synthetic.main.item.view.*

class ListAdapter(private val activity: MainActivity): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(product: Product, activity: MainActivity){
            itemView.tvAti.text = product.nameQq
            itemView.tvSI.text = product.olshemBirlik
            itemView.tvSumma.text = product.summa
            itemView.btnOptions.setOnClickListener {
                activity.itemOpMn(itemView.btnOptions,product, product.id)
            }
        }
    }

    var models: List<Product> = listOf()
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
        holder.populateModel(models[position],activity)
    }
}