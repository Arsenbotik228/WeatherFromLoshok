package com.geeks.mvvm15_1j.ui.fragments.favorits

import androidx.lifecycle.ViewModel
import com.geeks.mvvm15_1j.data.local.RoomRepository.RepositoryRoom
import com.geeks.mvvm15_1j.data.model.RickAndMortyCharacter
import com.geeks.mvvm15_1j.data.network.repository.CharacterRepository
import javax.inject.Inject

class FavoritsViewModel @Inject constructor(private val repository: RepositoryRoom):ViewModel(){
    fun getAllCharacter() = repository.getAllCharacters()

    fun addFavoriteCharacters(model:RickAndMortyCharacter) {
        repository.addFavoritesCharacter(model)
    }

}