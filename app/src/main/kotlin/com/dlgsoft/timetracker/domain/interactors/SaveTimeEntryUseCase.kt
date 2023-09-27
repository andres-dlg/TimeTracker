package com.dlgsoft.timetracker.domain.interactors

import com.dlgsoft.timetracker.domain.repositories.TimeEntryRepository
import com.dlgsoft.timetracker.presentation.common.Result
import java.util.Date
import javax.inject.Inject

class SaveTimeEntryUseCase @Inject constructor(
    private val timeEntryRepository: TimeEntryRepository
) {

  suspend fun saveTimeEntry(date: Date, totalHours: Double, notes: String?): Result<Unit?> =
      try {
        timeEntryRepository.insertTimeEntry(null, totalHours, date, notes)
        Result.Success(Unit)
      } catch (error: Exception) {
        Result.Error(error)
      }
}