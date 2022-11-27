package com.example.rickandmortycompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rickandmortycompose.model.SingleCharacter
import com.example.rickandmortycompose.ui.components.DatabaseKeys

@TypeConverters(value = [DataConverter::class])
@Database(
    entities = [(SingleCharacter::class)],
    version = DatabaseKeys.DATABASE_VERSION
)
abstract class RoomDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharactersDao
}