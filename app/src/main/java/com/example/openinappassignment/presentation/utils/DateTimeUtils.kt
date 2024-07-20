package com.example.openinappassignment.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(dateTimeString: String): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    val date = formatter.parse(dateTimeString)

    val outputFormatter = SimpleDateFormat("dd MMM yyyy")
    return outputFormatter.format(date)
}

fun getHourFromString(timeString: String): Int {
    // Get first two characters (hour)
    val hourString = timeString.substring(0, 2)
    return hourString.toInt()
}