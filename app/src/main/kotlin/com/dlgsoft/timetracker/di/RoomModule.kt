package com.dlgsoft.timetracker.di

import android.app.Application
import androidx.room.Room
import com.dlgsoft.timetracker.data.local.db.TimeTrackerDatabase
import com.dlgsoft.timetracker.data.local.db.TimeTrackerDatabase.Companion.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

  @Provides
  @Singleton
  fun provideTimeTrackerDatabase(application: Application): TimeTrackerDatabase = Room
      .databaseBuilder(application, TimeTrackerDatabase::class.java, DB_NAME)
      .build()

  @Provides
  @Singleton
  internal fun providesTimeEntryDao(db: TimeTrackerDatabase) = db.timeEntryDao()
}