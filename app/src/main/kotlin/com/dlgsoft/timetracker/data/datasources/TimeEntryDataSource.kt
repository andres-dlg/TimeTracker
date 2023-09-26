package com.dlgsoft.timetracker.data.datasources

import com.dlgsoft.timetracker.data.db.entities.TimeEntry
import java.util.Date

interface TimeEntryDataSource {

  suspend fun getById(id: Int): TimeEntry

  suspend fun getTimeEntries(fromDate: Date, toDate: Date): List<TimeEntry>

  suspend fun insertTimeEntry(id: Int?, totalHours: Double, date: Date, notes: String?)

  suspend fun removeTimeEntry(id: Int)
}