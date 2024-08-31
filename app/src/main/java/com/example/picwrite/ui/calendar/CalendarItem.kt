package com.example.picwrite.ui.calendar

sealed class CalendarItem {
    data class Header(val dayOfWeek: String) : CalendarItem()
    data class Day(val date: Int) : CalendarItem()
}