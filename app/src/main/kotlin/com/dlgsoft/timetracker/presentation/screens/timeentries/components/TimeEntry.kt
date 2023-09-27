package com.dlgsoft.timetracker.presentation.screens.timeentries.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dlgsoft.timetracker.R
import com.dlgsoft.timetracker.presentation.entities.TimeEntry

@Composable
fun TimeEntry(modifier: Modifier, timeEntry: TimeEntry) {
  Card(
      modifier = modifier,
      border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary),
      elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
  ) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
      TimeEntryItem(iconResId = R.drawable.ic_calendar_rounded, text = timeEntry.date)
      Spacer(Modifier.height(4.dp))
      TimeEntryItem(iconResId = R.drawable.ic_clock_rounded, text = timeEntry.totalHours.toString())
      timeEntry.notes?.let { notes ->
        Spacer(Modifier.height(4.dp))
        TimeEntryItem(iconResId = R.drawable.ic_notes_rounded, text = notes)
      }
    }
  }
}

@Composable
fun TimeEntryItem(iconResId: Int, text: String) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    Icon(
        painter = painterResource(id = iconResId),
        contentDescription = "Fecha",
        modifier = Modifier.size(24.dp)
    )
    Spacer(Modifier.width(4.dp))
    Text(text = text)
  }
}

@Preview
@Composable
fun TimeEntryPreview() {
  TimeEntry(
      modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth(),
      timeEntry = TimeEntry(0, 5.3, "10/10/2023", "Notas")
  )
}