package com.example.picwrite.ui.diarylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.picwrite.R
import com.example.picwrite.databinding.FragmentAlbumBinding
import com.example.picwrite.databinding.FragmentDiaryListBinding
import com.example.picwrite.ui.album.AlbumAdapter
import com.example.picwrite.ui.calendar.CalendarAdapter

class DiaryListFragment : Fragment() {
    private var _binding: FragmentDiaryListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiaryListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDiaryListBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 목록 표시
        // LinearLayoutManager 설정
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewDiaryList.layoutManager = layoutManager

//        // ViewModel의 데이터를 관찰하여 RecyclerView에 연결
        viewModel.items.observe(viewLifecycleOwner, Observer { items ->
            val adapter = DiaryListAdapter(items)
            binding.recyclerViewDiaryList.adapter = adapter
//            binding.recyclerViewDiaryList.adapter = DiaryListAdapter(items)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
