package com.rahul.cryptocurrency.presentation.viewstate

import com.rahul.cryptocurrency.domain.model.CoinDetailResponse

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetailResponse? = null,
    val error: String = ""
)
