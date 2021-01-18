package com.example.daggerhilt.util

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * String formatter for the log dates.
 */
class DateFormatter @Inject constructor() {

    private val formatter = SimpleDateFormat("d MMM yyyy HH:mm:ss", Locale.getDefault())

    fun formatDate(timestamp: Long): String {
        return formatter.format(Date(timestamp))
    }
}
