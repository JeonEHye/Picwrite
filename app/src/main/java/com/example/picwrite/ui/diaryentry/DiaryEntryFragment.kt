package com.example.picwrite.ui.diaryentry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.picwrite.R
import com.example.picwrite.databinding.FragmentDiaryEntryBinding
import com.google.firebase.firestore.FirebaseFirestore

class DiaryEntryFragment : Fragment() {

    private var _binding: FragmentDiaryEntryBinding? = null
    private val binding get() = _binding!!
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDiaryEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //데이터 연결을 위해서 작성해 봤던 내용
//        binding.btnDiaryEntryadd.setOnClickListener {
//            val id = UUID.randomUUID().toString()
//            val title = "테스트"
//            val content = "테스트 내용"
//            val newDiary = DiaryEntryItem(id, title, content)
//            diaryViewModel.addDiary(newDiary)
//
//        }

        // 다른 곳으로 이동을 해보자.
        // 뒤로가기 버튼 클릭 이벤트 처리
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_diaryEntryFragment_to_calendarFragment)
        }

        // 저장 버튼 클릭 이벤트 처리
        binding.btnDiaryEntryAdd.setOnClickListener {
            val title = binding.etCalendarDiaryEntryTitle.text.toString()
            val content = binding.etCalendarDiaryEntryContent.text.toString()

            // 데이터를 저장하는 로직 구현 (ex. ViewModel 또는 데이터베이스 사용)
            saveDiaryEntry(title, content)

            // 저장 후 뒤로가기
            parentFragmentManager.popBackStack()

        }
    }

    private fun saveDiaryEntry(title: String, content: String) {
        // 일기 데이터를 저장하는 함수 구현
        // 데이터베이스나 ViewModel을 사용해 데이터를 저장할 수 있음

        db.collection("DiaryCollection") // 폴더명
            .document(title) //제목
            .set(DiaryEntryItem(title,content))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
