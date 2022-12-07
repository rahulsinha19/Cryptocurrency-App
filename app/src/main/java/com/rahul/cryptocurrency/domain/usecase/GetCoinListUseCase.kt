package com.rahul.cryptocurrency.domain.usecase

import com.rahul.cryptocurrency.domain.model.CoinResponseModel
import com.rahul.cryptocurrency.domain.repository.CoinRepository
import com.rahul.cryptocurrency.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<ArrayList<CoinResponseModel>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}