package com.geeks.mvvm15_1j.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.local.RoomRepository.RepositoryRoom
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.RickAndMortyCharacter
import com.geeks.mvvm15_1j.data.network.repository.CharacterRepository
import com.geeks.mvvm15_1j.ui.App
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository,
    private val roomRepository: RepositoryRoom
) : ViewModel() {

    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>>()

    fun getCharacter(
        name: String,
        page: Int
    ) {
        liveData = repository.getCharacter(name, page)
    }
    fun addFavoriteCharacters(model:RickAndMortyCharacter) {
        roomRepository.addFavoritesCharacter(model)
    }
}