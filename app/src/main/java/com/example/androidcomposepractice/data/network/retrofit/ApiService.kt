package com.example.androidcomposepractice.data.network.retrofit

import com.example.androidcomposepractice.data.constants.APIData
import com.example.androidcomposepractice.data.model.response.ProductResItem
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST(APIData.PRODUCTS)
    suspend fun getProductList(): List<ProductResItem>
}