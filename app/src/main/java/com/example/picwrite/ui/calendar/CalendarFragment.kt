package com.example.picwrite.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
        val layoutManager =
            GridLayoutManager(requireContext(), 7)  // 7 columns for the days of the week
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
            val adapter = CalendarAdapter(items)
            binding.recyclerViewCalendar.adapter = adapter


            // 캘린더의 날짜 아이템 클릭 시, subbox 내용이 바뀌도록 연결

            adapter.itemClick = object : CalendarAdapter.OnItemClickListener {
                override fun onItemClick(item: CalendarItem) {
                    binding.tvCalendarDiaryEntryDate.text = "테스트 날짜"
                    binding.tvCalendarDiaryEntryTitle.text = "테스트 제목"
//                    binding.ivDiaryEntryMainPic1.drawable = ""
                    binding.tvCalendarDiaryEntrySubTitle1.text = "테스트 태그1"
                    binding.tvCalendarDiaryEntrySubTitle2.text = "테스트 태그2"
                    binding.tvCalendarDiaryEntrySubTitle3.text = "테스트 태그3"
                    //서버에서 날짜에 맞는 일기 정보를 받아와서 여기 위에서 출력. //일기 아이템 만들어서 넣기
                }
            }

        })

        //연락처 과제 숙련 개인과제 연락처 해설영상 일기정보 추가 // 가짜데이터
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

