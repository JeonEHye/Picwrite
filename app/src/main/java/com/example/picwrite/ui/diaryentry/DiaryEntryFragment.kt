package com.example.picwrite.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.picwrite.databinding.FragmentDiaryEntryBinding

class DiaryEntryFragment : Fragment() {

    private var _binding: FragmentDiaryEntryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiaryEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 저장 버튼 클릭 이벤트 처리
        binding.btnDiaryEntryAdd.setOnClickListener {
            val title = binding.tvCalendarDiaryEntryTitle.text.toString()
            val content = binding.tvCalendarDiaryEntryContent.text.toString()

            // 데이터를 저장하는 로직 구현 (ex. ViewModel 또는 데이터베이스 사용)
            saveDiaryEntry(title, content)
        }
    }

    private fun saveDiaryEntry(title: String, content: String) {
        // 일기 데이터를 저장하는 함수 구현
        // 데이터베이스나 ViewModel을 사용해 데이터를 저장할 수 있음
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
