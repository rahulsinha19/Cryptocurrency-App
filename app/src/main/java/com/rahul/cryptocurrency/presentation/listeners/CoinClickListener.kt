package com.rahul.cryptocurrency.presentation.listeners

import com.rahul.cryptocurrency.domain.model.CoinResponseModel

interface CoinClickListener {
    fun onClick(coinResponseModel: CoinResponseModel)
}