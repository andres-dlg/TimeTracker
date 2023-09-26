package com.dlgsoft.timetracker.data.repositories

import com.dlgsoft.timetracker.data.datasources.TimeEntryDataSourceFactory
import com.dlgsoft.timetracker.domain.entities.TimeEntry
import com.dlgsoft.timetracker.domain.repositories.TimeEntryRepository
import java.util.Date

class TimeEntryRepositoryImpl(
    private val timeEntryDataSourceFactory: TimeEntryDataSourceFactory
): TimeEntryRepository {

  override suspend fun getById(id: Int): TimeEntry =
      timeEntryDataSourceFactory.dataSource.getById(id).toDomainEntity()

  override suspend fun getTimeEntries(fromDate: Date, toDate: Date): List<TimeEntry> =
      timeEntryDataSourceFactory.dataSource.getTimeEntries(fromDate, toDate).map {
        it.toDomainEntity()
      }

  override suspend fun insertTimeEntry(id: Int?, totalHours: Double, date: Date, notes: String?) =
      timeEntryDataSourceFactory.dataSource.insertTimeEntry(id, totalHours, date, notes)

  override suspend fun removeTimeEntry(id: Int) = timeEntryDataSourceFactory.dataSource.removeTimeEntry(id)
}