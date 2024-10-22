package br.com.hellodev.fakestoreapp.presenter.features.details.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import br.com.hellodev.fakestoreapp.core.navigation.routes.AppRoutes
import br.com.hellodev.fakestoreapp.data.mapper.toDomain
import br.com.hellodev.fakestoreapp.domain.usecase.GetProductByIdUseCase
import br.com.hellodev.fakestoreapp.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import br.com.hellodev.fakestoreapp.presenter.features.details.action.ProductDetailsAction
import br.com.hellodev.fakestoreapp.presenter.features.details.state.ProductDetailsState

class ProductDetailsViewModel(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = MutableStateFlow(ProductDetailsState())
    var state: StateFlow<ProductDetailsState> = _state

    private val productId = savedStateHandle.toRoute<AppRoutes.ProductDetails>().id

    init {
        getProduct(productId)
        getProducts()
    }

    fun dispatchAction(action: ProductDetailsAction) {
        when (action) {
            is ProductDetailsAction.SelectProductColor -> {
                selectProductColor(colorId = action.colorId)
            }
        }
    }

    private fun getProduct(productId: Int?) {
        viewModelScope.launch {
            getProductByIdUseCase(productId).collectLatest { product ->
                _state.value = _state.value.copy(
                    isLoading = false,
                    product = product.toDomain(),
                    productColorSelected = product.colors?.firstOrNull()?.toDomain()
                )
            }
        }
    }

    private fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase().collectLatest { products ->
                _state.value = _state.value.copy(
                    isLoading = false,
                    products = products.map { it.toDomain() }
                )
            }
        }
    }

    private fun selectProductColor(colorId: Int?) {
        _state.value = _state.value.copy(
            productColorSelected = _state.value.product?.colors?.firstOrNull { it.id == colorId }
        )
    }

}