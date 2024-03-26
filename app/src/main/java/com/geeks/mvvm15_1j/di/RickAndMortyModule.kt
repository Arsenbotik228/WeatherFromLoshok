package com.geeks.mvvm15_1j.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.geeks.mvvm15_1j.data.local.RoomRepository.RepositoryRoom
import com.geeks.mvvm15_1j.data.local.dao.RickAndMoertyDao
import com.geeks.mvvm15_1j.data.local.dataBase.MainDataBase
import com.geeks.mvvm15_1j.data.network.repository.CharacterRepository
import com.geeks.mvvm15_1j.data.network.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RickAndMortyModule {
    @Provides
    @Singleton
    fun provideApiService(httpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun httpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(10000,TimeUnit.MILLISECONDS)
            .callTimeout(10000,TimeUnit.MILLISECONDS)
            .writeTimeout(10000,TimeUnit.MILLISECONDS)
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()

    }

    @Provides
    fun provideCharacterRepository(apiService: ApiService): CharacterRepository {
        return CharacterRepository(apiService)
    }
    @Singleton
    @Provides

    fun provideRoomDataBase(@ApplicationContext context: Context):MainDataBase{
        return databaseBuilder(context,MainDataBase::class.java,"room db").allowMainThreadQueries().build()
    }
    @Provides
    fun provideRoomRepository(dao:RickAndMoertyDao):RepositoryRoom{
        return RepositoryRoom(dao)
    }
    @Provides
    @Singleton
    fun getDa(db: MainDataBase):RickAndMoertyDao{
        return db.getDao()

    }
}