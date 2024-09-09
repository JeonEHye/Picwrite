package com.example.picwrite.ui.diarylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.picwrite.R

class DiaryListAdapter(private val itemList: List<DiaryListItem>) :
    RecyclerView.Adapter<DiaryListAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_diary_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.diaryListAdapterImageView.setImageResource(item.diaryListImage)
        holder.diaryListAdapterTextView.text = item.diaryListText
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val diaryListAdapterImageView: ImageView = itemView.findViewById(R.id.iv_diary_list)
        val diaryListAdapterTextView: TextView = itemView.findViewById(R.id.tv_diary_list)
    }
}