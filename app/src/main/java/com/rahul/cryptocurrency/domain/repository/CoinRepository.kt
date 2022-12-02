package com.rahul.cryptocurrency.domain.repository

import com.rahul.cryptocurrency.domain.model.CoinDetailResponse
import com.rahul.cryptocurrency.domain.model.CoinListResponse

interface CoinRepository {
    suspend fun getCoins(): List<CoinListResponse>

    suspend fun getCoinById(coinId: String): CoinDetailResponse
}