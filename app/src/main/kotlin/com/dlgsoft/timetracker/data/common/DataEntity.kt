package com.dlgsoft.timetracker.data.common

import com.dlgsoft.timetracker.domain.common.DomainEntity

interface DataEntity<out T: DomainEntity> {

  fun toDomainEntity(): T
}