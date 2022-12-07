package com.rahul.cryptocurrency.domain.repository

import com.rahul.cryptocurrency.domain.model.CoinDetailResponse
import com.rahul.cryptocurrency.domain.model.CoinResponseModel

interface CoinRepository {
    suspend fun getCoins(): ArrayList<CoinResponseModel>

    suspend fun getCoinById(coinId: String): CoinDetailResponse
}