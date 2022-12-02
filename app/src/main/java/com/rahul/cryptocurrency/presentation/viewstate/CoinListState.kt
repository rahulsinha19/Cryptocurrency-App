package com.rahul.cryptocurrency.presentation.viewstate

import com.rahul.cryptocurrency.domain.model.CoinListResponse

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<CoinListResponse> = emptyList(),
    val error: String = ""
)
