package com.dlgsoft.timetracker.presentation.screens.timeentries

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dlgsoft.timetracker.presentation.entities.TimeEntry
import com.dlgsoft.timetracker.presentation.screens.timeentries.components.TimeEntry
import com.dlgsoft.timetracker.presentation.ui.theme.TimeTrackerTheme
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeEntriesScreen(
    modifier: Modifier,
    timeEntries: List<TimeEntry>
) {
  Scaffold(
      modifier = modifier,
      floatingActionButton = {
        ExtendedFloatingActionButton(
            onClick = { /*TODO*/ }
        ) {
          Icon(
              imageVector = Icons.Filled.Add,
              contentDescription = "Cargar horas"
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text(text = "Cargar horas")
        }
      },
      content = {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
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
  )
}

@Preview(showBackground = true)
@Composable
fun TimeEntriesScreenPreview() {
  TimeTrackerTheme {
    TimeEntriesScreen(Modifier.fillMaxSize(), getMockedTimeEntries())
  }
}

fun getMockedTimeEntries(): List<TimeEntry> {
  return listOf(
      TimeEntry(0, 4.0, "10/10/2023", "Notas"),
      TimeEntry(1, 3.0, "11/10/2023", "Notas"),
      TimeEntry(2, 5.5, "12/10/2023", "Notas"),
      TimeEntry(3, 2.6, "13/10/2023", "Notas")
  )
}