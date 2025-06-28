package com.example.androidcomposepractice.data.network.usecase

import com.example.androidcomposepractice.data.model.response.ProductResItem
import com.example.androidcomposepractice.data.network.repository.Repository
import com.example.androidcomposepractice.ui.component.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val repository: Repository
) {
    //operator is used here to invoke class GetProductListUseCase instance
    operator fun invoke(): Flow<UiState<List<ProductResItem>>> = flow {
        emit(UiState.Loading)
        try {
            val result = repository.getProductList()
            emit(UiState.Success(result))
        } catch (e: Exception) {
            emit(UiState.Error(e.message ?: "Unknown Error"))
        }
    }.flowOn(Dispatchers.IO)
}
