package com.dlgsoft.timetracker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dlgsoft.timetracker.data.db.TimeTrackerDatabase.Companion.VERSION
import com.dlgsoft.timetracker.data.db.converters.DateConverter
import com.dlgsoft.timetracker.data.db.dao.TimeEntryDao
import com.dlgsoft.timetracker.data.db.entities.TimeEntry

@Database(
    version = VERSION,
    exportSchema = true,
    entities = [
      TimeEntry::class
    ]
)
@TypeConverters(
    value = [
      DateConverter::class
    ]
)
abstract class TimeTrackerDatabase: RoomDatabase() {

  abstract fun timeEntryDao(): TimeEntryDao

  companion object {
    const val DB_NAME = "TimeTrackerDB"
    const val VERSION = 1
  }
}