package com.rahul.cryptocurrency.domain.usecase

import com.rahul.cryptocurrency.domain.model.CoinDetailResponse
import com.rahul.cryptocurrency.domain.repository.CoinRepository
import com.rahul.cryptocurrency.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetailResponse>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = repository.getCoinById(coinId)
            emit(Resource.Success(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}