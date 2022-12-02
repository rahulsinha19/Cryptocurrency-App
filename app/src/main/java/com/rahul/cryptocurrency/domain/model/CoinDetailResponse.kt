package com.rahul.cryptocurrency.domain.model

import com.google.gson.annotations.SerializedName

data class CoinDetailResponse(
    @SerializedName("id")
    val coinId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("is_active")
    val isActive: Boolean,
)
