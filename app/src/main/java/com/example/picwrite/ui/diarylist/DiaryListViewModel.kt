package com.example.picwrite.ui.diarylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picwrite.R
import com.example.picwrite.ui.album.AlbumItem

class DiaryListViewModel  : ViewModel() {

    private val _items = MutableLiveData<List<AlbumItem>>()
//    val items: LiveData<List<AlbumItem>>
//        get() = _items

//
//    init {
//        val itemList = mutableListOf<AlbumItem>()
//        itemList.add(AlbumItem(R.drawable.picwrite, "1월"))
//        itemList.add(AlbumItem(R.drawable.picwrite, "2월"))
//        itemList.add(AlbumItem(R.drawable.picwrite, "3월"))
//        itemList.add(AlbumItem(R.drawable.picwrite, "4월"))
//        itemList.add(AlbumItem(R.drawable.picwrite, "5월"))
//        itemList.add(AlbumItem(R.drawable.picwrite, "6월"))
//
//        _items.value = itemList
//    }
}