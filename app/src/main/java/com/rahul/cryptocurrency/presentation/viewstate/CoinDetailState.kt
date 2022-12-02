package com.rahul.cryptocurrency.presentation.viewstate

import com.rahul.cryptocurrency.domain.model.CoinDetailResponse
import com.rahul.cryptocurrency.domain.model.CoinListResponse

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetailResponse? = null,
    val error: String = ""
)
