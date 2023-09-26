package com.dlgsoft.timetracker.di.modules

import com.dlgsoft.timetracker.data.datasources.TimeEntryDataSource
import com.dlgsoft.timetracker.data.datasources.TimeEntryDataSourceFactory
import com.dlgsoft.timetracker.data.datasources.TimeEntryDataSourceFactoryImpl
import com.dlgsoft.timetracker.data.datasources.TimeEntryLocalDataSource
import com.dlgsoft.timetracker.data.datasources.TimeEntryRemoteDataSource
import com.dlgsoft.timetracker.data.db.dao.TimeEntryDao
import com.dlgsoft.timetracker.data.repositories.TimeEntryRepositoryImpl
import com.dlgsoft.timetracker.domain.interactors.GetTimeEntriesUseCase
import com.dlgsoft.timetracker.domain.repositories.TimeEntryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class TimeEntryModule {

  @Provides
  fun providesTimeEntryLocalDataSource(
      timeEntryDao: TimeEntryDao
  ): TimeEntryDataSource = TimeEntryLocalDataSource(timeEntryDao)

  @Provides
  fun providesTimeEntryRemoteDataSource(): TimeEntryDataSource = TimeEntryRemoteDataSource()

  @Provides
  fun providesTimeEntryDataSourceFactory(
      timeEntryRemoteDataSource: TimeEntryRemoteDataSource,
      timeEntryLocalDataSource: TimeEntryLocalDataSource
  ): TimeEntryDataSourceFactory = TimeEntryDataSourceFactoryImpl(
      timeEntryLocalDataSource,
      timeEntryRemoteDataSource
  )

  @Provides
  fun provideTimeEntryRepository(
      timeEntryDataSourceFactory: TimeEntryDataSourceFactory
  ): TimeEntryRepository = TimeEntryRepositoryImpl(
      timeEntryDataSourceFactory
  )

  @Provides
  fun provideGetTimeEntriesUseCase(
      timeEntryRepository: TimeEntryRepository
  ): GetTimeEntriesUseCase = GetTimeEntriesUseCase(
      timeEntryRepository
  )
}