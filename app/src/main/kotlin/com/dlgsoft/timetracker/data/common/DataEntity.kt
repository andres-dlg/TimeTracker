package com.dlgsoft.timetracker.data.common

interface DataEntity<T> {

  fun toDomainEntity(): T
}