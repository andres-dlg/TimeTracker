package com.dlgsoft.timetracker.data.datasources

data class TimeEntryDataSourceFactoryImpl(
    private val localDataSource: TimeEntryLocalDataSource,
    private val remoteDataSource: TimeEntryRemoteDataSource
): TimeEntryDataSourceFactory {

  override val dataSource: TimeEntryDataSource
    get() = localDataSource
}

interface TimeEntryDataSourceFactory {
  val dataSource: TimeEntryDataSource
}