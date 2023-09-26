package com.dlgsoft.timetracker.domain.repositories

import com.dlgsoft.timetracker.domain.entities.TimeEntry
import java.util.Date

interface TimeEntryRepository {

  suspend fun getById(id: Int): TimeEntry

  suspend fun getTimeEntries(fromDate: Date, toDate: Date): List<TimeEntry>

  suspend fun insertTimeEntry(id: Int?, totalHours: Double, date: Date, notes: String?)

  suspend fun removeTimeEntry(id: Int)
}