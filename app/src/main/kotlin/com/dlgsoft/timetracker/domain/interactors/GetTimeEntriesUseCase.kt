package com.dlgsoft.timetracker.domain.interactors

import com.dlgsoft.timetracker.domain.repositories.TimeEntryRepository
import com.dlgsoft.timetracker.presentation.common.Result
import com.dlgsoft.timetracker.presentation.entities.TimeEntry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

class GetTimeEntriesUseCase(
    private val timeEntryRepository: TimeEntryRepository
) {

  suspend fun getTimeEntries(fromDate: Date, toDate: Date): Flow<Result<List<TimeEntry>?>> = flow {
    emit(Result.Loading(true))
    try {
      val entries = timeEntryRepository.getTimeEntries(fromDate, toDate).map {
        it.toPresentationEntity()
      }
      emit(Result.Success(data = entries))
    } catch (error: Exception) {
      emit(Result.Error(error))
    }
    emit(Result.Loading(false))
  }
}