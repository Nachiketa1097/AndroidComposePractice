package com.example.androidcomposepractice.ui.screens.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcomposepractice.data.model.response.ProductResItem
import com.example.androidcomposepractice.data.network.usecase.GetProductListUseCase
import com.example.androidcomposepractice.ui.component.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductListUseCase: GetProductListUseCase
) : ViewModel() {

    private val _productState = MutableStateFlow<UiState<List<ProductResItem>>>(UiState.Loading)
    val productState: StateFlow<UiState<List<ProductResItem>>> = _productState

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            getProductListUseCase().collect {
                _productState.value = it
            }
        }
    }
}
