package com.geeks.mvvm15_1j.data.model

data class BaseMainResponse<T>(
    val info: CharacterInfo,
    val results: List<T>
)