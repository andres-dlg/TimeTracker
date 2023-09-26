package com.dlgsoft.timetracker.data.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dlgsoft.timetracker.data.local.db.entities.TimeEntry.Companion.TABLE_NAME
import java.util.Date

@Entity(tableName = TABLE_NAME)
data class TimeEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val totalHours: Int = 0,
    val date: Date,
    val notes: String
) {

  companion object {
    const val TABLE_NAME = "TimeEntry"
  }
}