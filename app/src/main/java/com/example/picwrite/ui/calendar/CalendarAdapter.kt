package com.example.picwrite.ui.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.picwrite.R
import com.example.picwrite.ui.album.AlbumItem


// 달력 어댑터 생성(리사이클러뷰(달력 아이템)활용)
class CalendarAdapter(private val items: List<CalendarItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        //안에 달력 요소 클릭했을 때 반응
    interface OnItemClickListener {
        fun onItemClick(item:CalendarItem)
    }

    // 달력 요소를 클릭했을 때 할일을 나중에 설정하기 위함
    var itemClick : OnItemClickListener? = null

    //TYPE_HEADER(요일), DAY(날짜)의 상수 설정
    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_DAY = 1
    }

    //getItemViewType이라는 함수는 달력의 각 아이템이 제목(요일)인지 날짜인지를 구분
    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is CalendarItem.Header -> TYPE_HEADER
            is CalendarItem.Day -> TYPE_DAY
        }
    }

    //화면에 보여줄 칸을 만드는 역할, viewType에 따른 칸 생성
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

    // 칸에 실제 내용을 채워 넣는 역할, (제목: 요일, 날짜: 숫자) + 클릭했을 때 어떤 일이 일어날지 정함.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(items[position] as CalendarItem.Header)
            is DayViewHolder -> holder.bind(items[position] as CalendarItem.Day)
        }

        holder.itemView.setOnClickListener{
            itemClick?.onItemClick(items[position])
        }
    }

    //함수는 달력에 있는 전체 아이템 개수 알려주는 역할
    override fun getItemCount(): Int = items.size

    //HeaderViewHolder는 요일을 담을 칸을 만들고, 요일을 적어주는 역할
    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.item_calendar_header)
        fun bind(item: CalendarItem.Header) {
            textView.text = item.dayOfWeek
        }
    }

    //달력의 날짜를 보여주고, 날짜가 없는 빈 칸
    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.item_calendar_day)
        fun bind(item: CalendarItem.Day) {
            if (item.date == 0) {
                textView.text = "" // 빈 칸
            } else {
                textView.text = item.date.toString()
            }
        }
    }
}