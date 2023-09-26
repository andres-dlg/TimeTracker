package com.dlgsoft.timetracker.presentation.entities

import com.dlgsoft.timetracker.presentation.common.PresentationEntity
import java.util.Date

data class TimeEntry(
    val id: Int? = 0,
    val totalHours: Double = 0.0,
    val date: String,
    val notes: String?
): PresentationEntity