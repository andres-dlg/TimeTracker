package com.dlgsoft.timetracker.presentation.screens.timeentries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dlgsoft.timetracker.domain.interactors.GetTimeEntriesUseCase
import com.dlgsoft.timetracker.domain.interactors.SaveTimeEntryUseCase
import com.dlgsoft.timetracker.presentation.common.Result
import com.dlgsoft.timetracker.presentation.entities.TimeEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class TimeEntriesViewModel @Inject constructor(
    private val getTimeEntriesUseCase: GetTimeEntriesUseCase,
    private val saveTimeEntryUseCase: SaveTimeEntryUseCase
): ViewModel() {

  private val _timeEntries =
      MutableStateFlow<Result<List<TimeEntry>?>>(Result.Loading(isLoading = true))
  val timeEntries: StateFlow<Result<List<TimeEntry>?>>
    get() = _timeEntries

  fun getTimeEntries() {
    viewModelScope.launch(Dispatchers.IO) {

//      saveTimeEntryUseCase.saveTimeEntry(
//          totalHours = 5.0,
//          date = Date(2023, 9, 1),
//          notes = null
//      )
//
//      saveTimeEntryUseCase.saveTimeEntry(
//          totalHours = 6.0,
//          date = Date(2023, 9, 2),
//          notes = "Test notes"
//      )
//
//      saveTimeEntryUseCase.saveTimeEntry(
//          totalHours = 3.0,
//          date = Date(2023, 9, 3),
//          notes = "Jjaajajaj"
//      )
//
//      saveTimeEntryUseCase.saveTimeEntry(
//          totalHours = 5.5,
//          date = Date(2023, 9, 4),
//          notes = null
//      )

      with(_timeEntries) {
        emit(Result.Loading(isLoading = true))
        emit(
            getTimeEntriesUseCase.getTimeEntries(
                fromDate = Date(2023, 9, 1),
                toDate = Date(2023, 10, 1)
            )
        )
      }
    }
  }
}