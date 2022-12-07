package com.rahul.cryptocurrency.data.repository

import com.rahul.cryptocurrency.data.remote.Api
import com.rahul.cryptocurrency.domain.model.CoinDetailResponse
import com.rahul.cryptocurrency.domain.model.CoinResponseModel
import com.rahul.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: Api) : CoinRepository {
    override suspend fun getCoins(): ArrayList<CoinResponseModel> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailResponse {
        return api.getCoinById(coinId)
    }
}