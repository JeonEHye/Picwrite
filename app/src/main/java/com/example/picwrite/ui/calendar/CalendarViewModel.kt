package com.example.picwrite.ui.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.YearMonth

class CalendarViewModel : ViewModel() {
    // LiveData 사용해서 CalendarItem 관리, LiveData는 데이터 변경을 관찰할 수 있게 해줌.

    private val _items = MutableLiveData<List<CalendarItem>>()
    val items: LiveData<List<CalendarItem>> get() = _items
    // MutableLiveData를 사용해 내부적으로 데이터 변경,
    // LiveData만을 노출하여 데이터가 직접 수정안되도록 함.

    init {
        generateCalendarItems()
        // 달력 데이터를 생성하는 메서드
    }

    private fun generateCalendarItems(year: Int = 2024, month: Int = 8) {
        val items = mutableListOf<CalendarItem>()

        // 요일 헤더 추가
        val daysOfWeek = listOf("일", "월", "화", "수", "목", "금", "토")
        daysOfWeek.forEach { dayOfWeek ->
            items.add(CalendarItem.Header(dayOfWeek))
        }

        // 해당 연도와 월의 총 일수 계산
        val yearMonth = YearMonth.of(year, month)
        val daysInMonth = yearMonth.lengthOfMonth()

        // 1일부터 마지막 날짜까지 추가
        for (day in 1..daysInMonth) {
            items.add(CalendarItem.Day(day))
        }

        _items.value = items
    }
}