package com.example.picwrite.ui.diaryentry

data class DiaryEntryItem(
    val id: String = "",
    val date: String,           // 날짜, 예: "2024-09-05"
    val title: String = "",     // 일기 제목
    val photoUrl: String?,      // 사진 URL (사진이 없을 수도 있어서 nullable로 설정)
    val content: String = "",
    val isImportant: Boolean,   // 중요 일기 표시, 예: true (중요한 일기) 또는 false (일반 일기)
    val hashtags: List<String>  // 내용 관련 해시태그 목록, 예: listOf("#행복", "#일상", "#기록")
)
