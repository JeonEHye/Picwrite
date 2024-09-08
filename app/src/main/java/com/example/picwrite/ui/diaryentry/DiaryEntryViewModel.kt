package com.example.picwrite.ui.diaryentry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picwrite.ui.album.AlbumItem
import com.google.firebase.firestore.FirebaseFirestore

class DiaryEntryViewModel  : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val diarylist = mutableListOf<DiaryEntryItem>()
    private val _diaries = MutableLiveData<List<DiaryEntryItem>>(mutableListOf())
    val diaries: LiveData<List<DiaryEntryItem>> = _diaries

//    fun addDiary(diary: DiaryEntryItem) {
//        diarylist.add(0, diary)
//        _diaries.value = diarylist
//
//        db.collection("diaryCollection")
//            .document(diary.id)
//            .set(diary)
//    }
//    fun getIdeaById(id: String?): DiaryEntryItem {
//        val index = diarylist.indexOfFirst { it.id == id }
//        return diarylist[index]
//    }
}

