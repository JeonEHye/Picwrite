package com.example.picwrite.ui.diarylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picwrite.R
import com.example.picwrite.ui.diarylist.DiaryListItem

class DiaryListViewModel  : ViewModel() {

    private val _items = MutableLiveData<List<DiaryListItem>>()
    val items: LiveData<List<DiaryListItem>>
        get() = _items

    init {
        val itemList = mutableListOf<DiaryListItem>()
        itemList.add(DiaryListItem(R.drawable.picwrite, "1월"))
        itemList.add(DiaryListItem(R.drawable.picwrite, "1월"))
        itemList.add(DiaryListItem(R.drawable.picwrite, "1월"))
        itemList.add(DiaryListItem(R.drawable.picwrite, "1월"))
        itemList.add(DiaryListItem(R.drawable.picwrite, "1월"))

        _items.value = itemList
    }
}