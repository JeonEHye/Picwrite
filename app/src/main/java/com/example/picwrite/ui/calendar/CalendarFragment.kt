package com.example.picwrite.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.picwrite.R
import com.example.picwrite.databinding.FragmentCalendarBinding
import com.example.picwrite.ui.diaryentry.DiaryEntryItem
import com.example.picwrite.ui.diaryentry.DiaryEntryViewModel
import java.util.UUID


class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CalendarViewModel by viewModels()
    private val diaryViewModel: DiaryEntryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // GridLayoutManager 설정
        val layoutManager =
            GridLayoutManager(requireContext(), 7)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return 1
            }
        }

        // [달력 프래그먼트 상단의 달력, CalenarViewModel이랑 연결한 viewModel 변수를 사용함]
        binding.recyclerViewCalendar.layoutManager = layoutManager

        // 서버랑 연결이 되어야 함(신튜터)
        // ViewModel의 데이터를 관찰하여 RecyclerView에 연결
        viewModel.items.observe(viewLifecycleOwner, Observer { items ->
            val adapter = CalendarAdapter(items)
            binding.recyclerViewCalendar.adapter = adapter

            // 캘린더의 날짜 아이템 클릭 시, subbox 내용이 바뀌도록 연결
            adapter.itemClick = object : CalendarAdapter.OnItemClickListener {
                override fun onItemClick(item: CalendarItem) {
                    binding.tvCalendarDiaryEntryDate.text = "테스트 날짜"
                    binding.tvCalendarDiaryEntryTitle.text = "테스트 제목"
                    binding.tvCalendarDiaryEntrySubTitle1.text = "테스트 태그1"
                    binding.tvCalendarDiaryEntrySubTitle2.text = "테스트 태그2"
                    binding.tvCalendarDiaryEntrySubTitle3.text = "테스트 태그3"
                    //서버에서 날짜에 맞는 일기 정보를 받아와서 여기 위에서 출력. //일기 아이템 만들어서 넣기
                }
            }
        })

        // [달력 프래그먼트 하단의 일기 미리보기, DiaryEntryViewModel 이랑 연결한 diaryviewmodel 변수를 사용 해야함.]



        //연락처 과제 숙련 개인과제 연락처 해설영상 일기정보 추가 // 가짜데이터
        return root
    }

    // [ 이동 관련 코드 구간 시작 ]

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 다른 곳으로 이동을 해보자.
        // 일기 작성 추가 클릭 이벤트 설정
        binding.btnDiaryEntryFragment.setOnClickListener {
            findNavController().navigate(R.id.action_calendarFragment_to_diaryEntryFragment)
        }

        // 일기 목록 클릭 이벤트
        binding.btnDiaryList.setOnClickListener {
            findNavController().navigate(R.id.action_calendarFragment_to_diaryListFragment)
        }

        // 일기 디테일 페이지로 이동
        binding.viewCalendarSubBox.setOnClickListener {
            findNavController().navigate(R.id.action_calendarFragment_to_diaryEntryFragment)
        }

        //데이터 연결을 위해서 작성해 봤던 내용
//        binding.btnDiaryEntryadd.setOnClickListener {
//            val id = UUID.randomUUID().toString()
//            val title = "테스트"
//            val content = "테스트 내용"
//            val newDiary = DiaryEntryItem(id, title, content)
//            diaryViewModel.addDiary(newDiary)
//
//        }

        //1차 시도
//            // 이동하려는 프래그먼트를 인스턴스화
//            val diaryEntryFragment = DiaryEntryFragment()
//            // 프래그먼트 매니저를 통해 트랜잭션 시작
//            val transaction = requireActivity().supportFragmentManager.beginTransaction()
//            // 현재 프래그먼트를 새로운 프래그먼트로 교체
//            transaction.replace(R.id.fragment_diary_entry_xml, diaryEntryFragment)
//            // 뒤로 가기 버튼을 눌렀을 때 이전 프래그먼트로 돌아오게 하기 위해 백스택에 추가
//            transaction.addToBackStack(null)
//            // 트랜잭션 완료
//            transaction.commit()
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


