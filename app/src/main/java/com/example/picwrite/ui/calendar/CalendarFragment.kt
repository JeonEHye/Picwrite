package com.example.picwrite.ui.calendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.picwrite.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null

    private val binding get() = _binding!!
    private val viewModel: CalendarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // GridLayoutManager 설정
        val layoutManager = GridLayoutManager(requireContext(), 7)  // 7 columns for the days of the week
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return 1
                /*return when (items[position]) {
                    is CalendarItem.Header -> 1  // 1 column for header
                    is CalendarItem.Day -> 1     // 1 column for each day
                }*/
            }
        }

        binding.recyclerViewCalendar.layoutManager = layoutManager

        // ViewModel의 데이터를 관찰하여 RecyclerView에 연결
        viewModel.items.observe(viewLifecycleOwner, Observer { items ->
            binding.recyclerViewCalendar.adapter = CalendarAdapter(items)

// 캘린더의 날짜 아이템 클릭 시, 내용이 바뀌도록 시도했던 흔적
//            CalendarAdapter(items).itemClick = object : CalendarAdapter.OnItemClickListner {
//                override fun onItemClick(item: CalendarItem) {
//                    binding.tvCalendarDiaryEntryDate.text = "테스트"
//                }
//            }

        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

