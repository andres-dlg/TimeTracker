package com.dlgsoft.timetracker.data.datasources

import com.dlgsoft.timetracker.data.db.entities.TimeEntry
import java.util.Date
import javax.inject.Inject

class TimeEntryRemoteDataSource @Inject constructor(): TimeEntryDataSource {

  override suspend fun getById(id: Int): TimeEntry {
    TODO("Not yet implemented")
  }

  override suspend fun getTimeEntries(fromDate: Date, toDate: Date): List<TimeEntry> {
    TODO("Not yet implemented")
  }

  override suspend fun insertTimeEntry(id: Int?, totalHours: Double, date: Date, notes: String?) {
    TODO("Not yet implemented")
  }

  override suspend fun removeTimeEntry(id: Int) {
    TODO("Not yet implemented")
  }
}