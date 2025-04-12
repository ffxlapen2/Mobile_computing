package com.example.loginapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loginapp.R
import com.example.loginapp.model.Item
import com.example.loginapp.ItemCardActivity

class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.textTitle)
        val desc: TextView = itemView.findViewById(R.id.textDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = itemList[position]
        holder.image.setImageResource(item.imageSource)
        holder.title.text = item.imageTitle
        holder.desc.text = item.imageDesc

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ItemCardActivity::class.java)
            intent.putExtra("item", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = itemList.size
}
