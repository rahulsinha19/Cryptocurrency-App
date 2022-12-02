package com.rahul.cryptocurrency.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rahul.cryptocurrency.domain.usecase.GetCoinDetailUseCase
import com.rahul.cryptocurrency.presentation.viewstate.CoinDetailState
import com.rahul.cryptocurrency.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow<CoinDetailState>(CoinDetailState())
    val state: StateFlow<CoinDetailState> = _state

    private fun getCoinDetail(coinId: String) {
        getCoinDetailUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinDetail = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }
    }
}