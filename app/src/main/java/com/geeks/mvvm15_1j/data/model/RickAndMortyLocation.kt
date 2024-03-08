package com.geeks.mvvm15_1j.data.model

import com.google.gson.annotations.SerializedName

data class RickAndMortyLocation(
    @SerializedName("name")
    val locationName: String,
    val url: String,
)
