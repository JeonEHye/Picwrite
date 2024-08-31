package com.example.picwrite.ui.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.picwrite.R

class CalendarAdapter(private val items: List<CalendarItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_DAY = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is CalendarItem.Header -> TYPE_HEADER
            is CalendarItem.Day -> TYPE_DAY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_header, parent, false)
            )
            TYPE_DAY -> DayViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_day, parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(items[position] as CalendarItem.Header)
            is DayViewHolder -> holder.bind(items[position] as CalendarItem.Day)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.item_calendar_header)
        fun bind(item: CalendarItem.Header) {
            textView.text = item.dayOfWeek
        }
    }

    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.item_calendar_day)
        fun bind(item: CalendarItem.Day) {
            textView.text = item.date.toString()
        }
    }
}