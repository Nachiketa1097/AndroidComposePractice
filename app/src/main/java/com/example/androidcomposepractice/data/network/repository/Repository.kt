package com.example.androidcomposepractice.data.network.repository

import com.example.androidcomposepractice.data.model.response.ProductResItem

interface Repository {
    suspend fun getProductList() : List<ProductResItem>
}