package com.example.androidcomposepractice.data.network.repository

import com.example.androidcomposepractice.data.model.response.ProductResItem
import com.example.androidcomposepractice.data.network.retrofit.ApiService
import jakarta.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {
    override suspend fun getProductList(): List<ProductResItem> {
        return apiService.getProductList()
    }
}
