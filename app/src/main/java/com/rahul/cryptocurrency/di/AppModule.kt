package com.rahul.cryptocurrency.di

import com.rahul.cryptocurrency.data.remote.Api
import com.rahul.cryptocurrency.data.repository.CoinRepositoryImpl
import com.rahul.cryptocurrency.domain.repository.CoinRepository
import com.rahul.cryptocurrency.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): Api {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: Api) : CoinRepository {
        return CoinRepositoryImpl(api)
    }
}