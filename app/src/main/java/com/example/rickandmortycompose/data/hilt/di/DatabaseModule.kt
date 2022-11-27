package com.example.rickandmortycompose.data.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.rickandmortycompose.data.room.CharactersDao
import com.example.rickandmortycompose.data.room.RoomDatabase
import com.example.rickandmortycompose.ui.components.DatabaseKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideCharactersDao(roomDatabase: RoomDatabase): CharactersDao =
        roomDatabase.charactersDao()

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext appContext: Context): RoomDatabase =
        Room.databaseBuilder(
            appContext,
            RoomDatabase::class.java,
            DatabaseKeys.DATABASE_NAME
        ).build()
}