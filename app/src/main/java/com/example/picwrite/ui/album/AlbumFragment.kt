package com.example.picwrite.ui.album

import AlbumAdapter
import AlbumViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.picwrite.databinding.FragmentAlbumBinding
import com.example.picwrite.ui.calendar.CalendarAdapter

class AlbumFragment : Fragment() {

    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // 앨범 상단 리사이클러뷰 달력 12개 표시
        // GridLayoutManager 설정
        val layoutManager = GridLayoutManager(requireContext(), 4)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return 1
            }
        }

        binding.albumRecyclerView.layoutManager = layoutManager

        // ViewModel의 데이터를 관찰하여 RecyclerView에 연결
        viewModel.items.observe(viewLifecycleOwner, Observer { items ->
            binding.albumRecyclerView.adapter = AlbumAdapter(items)
        })

        // 앨범 하단 리사이클러뷰 달력 12개 표시
        // GridLayoutManager 설정
        val layoutManager2 = GridLayoutManager(requireContext(), 3)
        layoutManager2.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return 1
            }
        }

        binding.albumRecyclerView2.layoutManager = layoutManager2

        // ViewModel의 데이터를 관찰하여 RecyclerView에 연결
        viewModel.items2.observe(viewLifecycleOwner, Observer { items ->
            binding.albumRecyclerView2.adapter = AlbumAdapter(items)
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