package com.example.daggerhilt.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that represent the a table in the database.
 */
@Entity(tableName = "logs")
data class Log(
    val message: String,
    val timeStamp: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
