package com.dlgsoft.timetracker.domain.interactors

import com.dlgsoft.timetracker.domain.repositories.TimeEntryRepository
import com.dlgsoft.timetracker.presentation.common.Result
import com.dlgsoft.timetracker.presentation.entities.TimeEntry
import java.util.Date
import javax.inject.Inject

class GetTimeEntriesUseCase @Inject constructor(
    private val timeEntryRepository: TimeEntryRepository
) {

  suspend fun getTimeEntries(fromDate: Date, toDate: Date): Result<List<TimeEntry>?> =
      try {
        val entries = timeEntryRepository.getTimeEntries(fromDate, toDate).map {
          it.toPresentationEntity()
        }
        Result.Success(data = entries)
      } catch (error: Exception) {
        Result.Error(error)
      }
}