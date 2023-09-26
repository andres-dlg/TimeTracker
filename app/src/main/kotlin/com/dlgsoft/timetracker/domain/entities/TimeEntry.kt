package com.dlgsoft.timetracker.domain.entities

import com.dlgsoft.timetracker.domain.common.DomainEntity
import java.util.Date

data class TimeEntry(
    val id: Int? = 0,
    val totalHours: Double = 0.0,
    val date: Date,
    val notes: String?
): DomainEntity