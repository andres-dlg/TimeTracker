package com.dlgsoft.timetracker.presentation.screens.timeentries

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dlgsoft.timetracker.presentation.common.Result
import com.dlgsoft.timetracker.presentation.screens.timeentries.components.TimeEntryList
import com.dlgsoft.timetracker.presentation.ui.theme.TimeTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeEntriesScreen(
    modifier: Modifier,
    viewModel: TimeEntriesViewModel = hiltViewModel()
) {
  val timeEntriesResult by viewModel.timeEntries.collectAsStateWithLifecycle()

  LaunchedEffect(key1 = Unit) {
    viewModel.getTimeEntries()
  }

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
        when(timeEntriesResult) {
          is Result.Error -> Text("Something went wrong")
          is Result.Loading -> CircularProgressIndicator()
          is Result.Success -> TimeEntryList(
              modifier = Modifier
                  .padding(it)
                  .fillMaxSize(),
              timeEntries = timeEntriesResult.data ?: listOf()
          )
        }
      }
  )
}

@Preview(showBackground = true)
@Composable
fun TimeEntriesScreenPreview() {
  TimeTrackerTheme {
    TimeEntriesScreen(Modifier.fillMaxSize())
  }
}