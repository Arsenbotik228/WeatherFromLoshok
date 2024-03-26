package com.geeks.mvvm15_1j.data.local.dataBase

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.geeks.mvvm15_1j.data.local.dao.RickAndMoertyDao
import com.geeks.mvvm15_1j.data.model.RickAndMortyCharacter

@Database(entities = [RickAndMortyCharacter::class], version = 1)
abstract class MainDataBase:RoomDatabase() {
    abstract fun getDao(): RickAndMoertyDao
}