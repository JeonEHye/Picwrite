package com.example.picwrite.ui.diaryentry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picwrite.ui.album.AlbumItem

class DiaryEntryViewModel  : ViewModel() {

    private val _items = MutableLiveData<List<AlbumItem>>()
//    val items: LiveData<List<AlbumItem>>
//        get() = _items{
}