package com.geeks.mvvm15_1j.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geeks.mvvm15_1j.data.model.RickAndMortyCharacter

@Dao

interface RickAndMoertyDao {
    @Query("SELECT * FROM RickAndMortyCharacter")
    fun getAllCharacters():List<RickAndMortyCharacter>
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun addFavoritesCharacters(model:RickAndMortyCharacter)
    @Delete
    fun deleteCharacters(model: RickAndMortyCharacter)
}