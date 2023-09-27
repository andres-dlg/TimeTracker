package com.dlgsoft.timetracker.presentation.screens.timeentries.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dlgsoft.timetracker.presentation.entities.TimeEntry

@Composable
fun TimeEntryList(modifier: Modifier, timeEntries: List<TimeEntry>) {
  LazyColumn(
      modifier = modifier,
      contentPadding = PaddingValues(top = 16.dp, bottom = 80.dp),
      content = {
        items(timeEntries) { entry ->
          TimeEntry(
              modifier = Modifier
                  .padding(horizontal = 16.dp, vertical = 6.dp)
                  .fillMaxWidth(), timeEntry = entry
          )
        }
      }
  )
}

@Preview
@Composable
fun TimeEntryListPreview() {
  TimeEntryList(modifier = Modifier.fillMaxSize(), timeEntries = getMockedTimeEntries())
}

private fun getMockedTimeEntries(): List<TimeEntry> {
  return listOf(
      TimeEntry(0, 4.0, "10/10/2023", "Notas"),
      TimeEntry(1, 3.0, "11/10/2023", "Notas"),
      TimeEntry(2, 5.5, "12/10/2023", "Notas"),
      TimeEntry(3, 2.6, "13/10/2023", "Notas")
  )
}