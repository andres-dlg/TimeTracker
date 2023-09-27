package com.dlgsoft.timetracker.data.datasources

import com.dlgsoft.timetracker.data.db.dao.TimeEntryDao
import com.dlgsoft.timetracker.data.db.entities.TimeEntry
import java.util.Date
import javax.inject.Inject

class TimeEntryLocalDataSource @Inject constructor(
    private val timeEntryDao: TimeEntryDao
): TimeEntryDataSource {

  override suspend fun getById(id: Int): TimeEntry = timeEntryDao.getById(id)

  override suspend fun getTimeEntries(fromDate: Date, toDate: Date): List<TimeEntry> =
      timeEntryDao.getEntries(fromDate, toDate)

  override suspend fun insertTimeEntry(id: Int?, totalHours: Double, date: Date, notes: String?) {
    timeEntryDao.upsert(
        TimeEntry(id, totalHours, date, notes)
    )
  }

  override suspend fun removeTimeEntry(id: Int) {
    with(timeEntryDao) {
      val timeEntryToRemove = getById(id)
      remove(timeEntryToRemove)
    }
  }
}