package com.dlgsoft.timetracker.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.dlgsoft.timetracker.data.local.db.entities.TimeEntry

@Dao
interface TimeEntryDao {

  @Upsert
  fun insert(entry: TimeEntry)

  @Delete
  fun remove(entry: TimeEntry)
}