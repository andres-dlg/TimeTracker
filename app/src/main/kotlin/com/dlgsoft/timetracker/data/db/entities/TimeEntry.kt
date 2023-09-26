package com.dlgsoft.timetracker.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dlgsoft.timetracker.data.common.DataEntity
import com.dlgsoft.timetracker.data.db.entities.TimeEntry.Companion.TABLE_NAME
import com.dlgsoft.timetracker.domain.entities.TimeEntry
import java.util.Date

@Entity(tableName = TABLE_NAME)
data class TimeEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val totalHours: Double = 0.0,
    val date: Date,
    val notes: String?
): DataEntity<TimeEntry> {

  override fun toDomainEntity(): TimeEntry = TimeEntry(id, totalHours, date, notes)

  companion object {
    const val TABLE_NAME = "TimeEntry"
  }
}