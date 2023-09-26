package com.dlgsoft.timetracker.domain.common

interface DomainEntity<T> {

  fun toPresentationEntity(): T
}