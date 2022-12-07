package com.rahul.cryptocurrency.presentation.viewstate

import com.rahul.cryptocurrency.domain.model.CoinResponseModel

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: ArrayList<CoinResponseModel> = ArrayList(),
    val error: String = ""
)
