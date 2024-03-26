package com.geeks.mvvm15_1j.data.local.RoomRepository

import com.geeks.mvvm15_1j.data.local.dao.RickAndMoertyDao
import com.geeks.mvvm15_1j.data.local.dataBase.MainDataBase
import com.geeks.mvvm15_1j.data.model.RickAndMortyCharacter
import javax.inject.Inject

class RepositoryRoom @Inject constructor( private val db: RickAndMoertyDao) {
    fun getAllCharacters():List<RickAndMortyCharacter>{
        return db.getAllCharacters()
    }

    fun addFavoritesCharacter(model: RickAndMortyCharacter){
        db.addFavoritesCharacters(model = model)
    }

    fun deleteFavoriteCharacters(model: RickAndMortyCharacter){
        db.deleteCharacters(model = model)
    }
}