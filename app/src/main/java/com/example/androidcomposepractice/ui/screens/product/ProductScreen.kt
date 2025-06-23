package com.example.androidcomposepractice.ui.screens.product

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidcomposepractice.data.model.response.ProductResItem
import com.example.androidcomposepractice.ui.component.UiState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProductScreen(modifier: Modifier = Modifier, viewModel: ProductViewModel = hiltViewModel()) {
    val state by viewModel.productState.collectAsState()

    when (state) {
        is UiState.Loading -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is UiState.Success -> {
            val productList = (state as UiState.Success<List<ProductResItem>>).data
            LazyColumn(modifier = modifier) {
                items(productList) { product ->
                    Text(text = product.title ?: "No Title", modifier = Modifier.padding(16.dp))
                }
            }
        }

        is UiState.Error -> {
            val message = (state as UiState.Error).message
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: $message", color = Color.Red)
            }
        }
    }
}
