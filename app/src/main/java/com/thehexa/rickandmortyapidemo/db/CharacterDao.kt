package com.thehexa.rickandmortyapidemo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thehexa.rickandmortyapidemo.model.Character

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters() : LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacter(id: Int): LiveData<Character>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Character>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: Character)

}