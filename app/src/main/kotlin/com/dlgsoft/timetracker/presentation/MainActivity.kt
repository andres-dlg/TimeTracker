package com.dlgsoft.timetracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.dlgsoft.timetracker.presentation.screens.timeentries.TimeEntriesScreen
import com.dlgsoft.timetracker.presentation.ui.theme.TimeTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TimeTrackerTheme {
        TimeEntriesScreen(Modifier.fillMaxSize())
      }
    }
  }
}