package com.example.picwrite.ui.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.picwrite.R

class AlbumAdapter(private val itemList: List<AlbumItem>) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.albumAdapterImageView.setImageResource(item.albumImage)
        holder.albumAdapterTextView.text = item.albumText
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val albumAdapterImageView: ImageView = itemView.findViewById(R.id.iv_album_item)
        val albumAdapterTextView: TextView = itemView.findViewById(R.id.tv_album_item)
    }
}
