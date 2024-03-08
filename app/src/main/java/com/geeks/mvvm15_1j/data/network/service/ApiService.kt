package com.geeks.mvvm15_1j.data.network.service

import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.RickAndMortyCharacter
import com.geeks.mvvm15_1j.data.model.RickAndMortyLocation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getAllCharacter(
        @Query("name") name: String? = null, // По имени
        @Query("status") status: String? = null, // Жив или мертв или неизвестно
        @Query("gender") gender: String? = null, // Мужчина или женщина или неизвестно
        @Query("species") species: String? = null, // Человек или пришелец
    ): Call<BaseMainResponse<RickAndMortyCharacter>>
}