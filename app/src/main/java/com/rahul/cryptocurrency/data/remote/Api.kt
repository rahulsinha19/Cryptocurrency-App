package com.rahul.cryptocurrency.data.remote

import com.rahul.cryptocurrency.domain.model.CoinDetailResponse
import com.rahul.cryptocurrency.domain.model.CoinResponseModel
import com.rahul.cryptocurrency.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET(Constants.COIN_LIST)
    suspend fun getCoins(): ArrayList<CoinResponseModel>

    @GET(Constants.COIN_BY_ID)
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailResponse
}