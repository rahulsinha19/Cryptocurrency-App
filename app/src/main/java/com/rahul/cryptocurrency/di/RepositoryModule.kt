package com.rahul.cryptocurrency.di

import com.rahul.cryptocurrency.data.repository.CoinRepositoryImpl
import com.rahul.cryptocurrency.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideCoinRepository(coinRepositoryImpl: CoinRepositoryImpl) : CoinRepository
}