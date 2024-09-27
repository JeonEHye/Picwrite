package com.example.picwrite.ui.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

class CalendarViewModel : ViewModel() {
    // LiveData 사용해서 CalendarItem 관리, LiveData는 데이터 변경을 관찰할 수 있게 해줌.

    private val _items = MutableLiveData<List<CalendarItem>>()
    val items: LiveData<List<CalendarItem>> get() = _items
//    // MutableLiveData를 사용해 내부적으로 데이터 변경,
//    // LiveData만을 노출하여 데이터가 직접 수정안되도록 함.
//
//    init {
//        generateCalendarItems()
//        // 달력 데이터를 생성하는 메서드
//    }

    private var selectedYear = LocalDate.now().year
    private var selectedMonth = LocalDate.now().monthValue

    // 초기화 시 현재 연도와 월로 달력 생성
    init {
        generateCalendarItems(selectedYear, selectedMonth)
    }

    // 특정 연도와 월을 설정하는 함수 추가
    fun setYearMonth(year: Int, month: Int) {
        selectedYear = year
        selectedMonth = month
        generateCalendarItems(selectedYear, selectedMonth)
    }

    private fun generateCalendarItems(year: Int, month: Int) {
        val items = mutableListOf<CalendarItem>()

        // 요일 헤더 추가
        val daysOfWeek = listOf("일", "월", "화", "수", "목", "금", "토")
        daysOfWeek.forEach { dayOfWeek ->
            items.add(CalendarItem.Header(dayOfWeek))
        }

        // 해당 연도와 월의 총 일수 계산
        val yearMonth = YearMonth.of(year, month)
        val daysInMonth = yearMonth.lengthOfMonth()
        // 그 달의 날짜 계산
        val firstDayOfMonth = LocalDate.of(year, month, 1)
        val dayOfWeek = firstDayOfMonth.dayOfWeek.value % 7  // 일요일이 0이 되도록 변환

        // 1일부터 마지막 날짜까지 추가
        for (day in 1..daysInMonth) {
            items.add(CalendarItem.Day(day))
        }

        // 첫 번째 요일 이전에 빈 칸 추가
        for (i in 0 until dayOfWeek) {
            items.add(CalendarItem.Day(0)) // 빈 칸
        }

        _items.value = items
    }

//    fun generateCalendarItems(year: Int, month: Int): List<CalendarItem> {
//        val items = mutableListOf<CalendarItem>()
//
//        // Header: 요일 추가 (일, 월, 화, ...)
//        val daysOfWeek = listOf("일", "월", "화", "수", "목", "금", "토")
//        daysOfWeek.forEach { dayOfWeek ->
//            items.add(CalendarItem.Header(dayOfWeek))
//        }
//
//        // Day: 해당 월의 날짜 추가
//        val yearMonth = YearMonth.of(year, month)
//        val firstDayOfMonth = yearMonth.atDay(1)
//        val lastDayOfMonth = yearMonth.atEndOfMonth()
//
//        // 첫째 날의 요일 계산 (1 = 월요일, 7 = 일요일)
//        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7 // 일요일을 0으로 맞춤
//
//        // 빈 칸 추가 (해당 월의 첫 번째 날짜까지 맞춤)
//        for (i in 0 until firstDayOfWeek) {
//            items.add(CalendarItem.Day(0)) // 빈 칸을 0으로 처리
//        }
//
//        // 날짜 추가
//        for (date in 1..lastDayOfMonth.dayOfMonth) {
//            items.add(CalendarItem.Day(date))
//        }
//
//        return items
//    }

//    val currentYear = LocalDate.now().year
//    val currentMonth = LocalDate.now().monthValue
//    val calendarItems = generateCalendarItems(currentYear, currentMonth)

//    val adapter = CalendarAdapter(calendarItems)

}