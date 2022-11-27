package com.example.rickandmortycompose.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.rickandmortycompose.model.SingleCharacter

@Dao
interface CharactersDao {

    @Insert
    fun insertSingleCharacter(character: SingleCharacter)

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): List<SingleCharacter>

    @Query("SELECT * FROM characters WHERE isFavorite = 1")
    suspend fun getFavoritesCharacters(): List<SingleCharacter>

    @Delete
    fun deleteSingleCharacter(character: SingleCharacter)

    @Query("SELECT * FROM characters WHERE id = :characterId")
    fun getSingleCharacterById(characterId: Int): SingleCharacter
}