package com.rahul.cryptocurrency.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.cryptocurrency.domain.usecase.GetCoinListUseCase
import com.rahul.cryptocurrency.presentation.viewstate.CoinListState
import com.rahul.cryptocurrency.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinListUseCase: GetCoinListUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow<CoinListState>(CoinListState())
    val state: StateFlow<CoinListState> = _state

    init {
        getCoinList()
    }

    private fun getCoinList() {
        getCoinListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coinList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}