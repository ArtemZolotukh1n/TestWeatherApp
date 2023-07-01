package com.example.testweatherapp.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


/**
 * Converts a Unix timestamp to a formatted time string.
 *
 * @param timeStamp The Unix timestamp to be converted.
 * @return The time in "HH:mm" format, presented in the GMT timezone.
 */
fun convertUnixToTime(timeStamp: Int): String {
    val date = Date(timeStamp * 1000L)
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
    sdf.timeZone = TimeZone.getTimeZone("GMT")
    return sdf.format(date)
}
