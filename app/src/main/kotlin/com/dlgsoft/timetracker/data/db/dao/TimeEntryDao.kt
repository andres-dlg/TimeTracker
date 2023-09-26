package com.dlgsoft.timetracker.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.dlgsoft.timetracker.data.db.entities.TimeEntry
import java.util.Date

@Dao
interface TimeEntryDao {

  @Upsert
  suspend fun upsert(entry: TimeEntry)

  @Delete
  suspend fun remove(entry: TimeEntry)

  @Query("SELECT * FROM timeentry WHERE date BETWEEN :fromDate AND :toDate")
  suspend fun getEntries(fromDate: Date, toDate: Date): List<TimeEntry>

  @Query("SELECT * FROM timeentry WHERE id = :id")
  suspend fun getById(id: Int): TimeEntry
}