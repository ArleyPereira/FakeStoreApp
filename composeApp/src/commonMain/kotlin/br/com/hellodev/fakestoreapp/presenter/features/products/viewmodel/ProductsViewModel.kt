package br.com.hellodev.fakestoreapp.presenter.features.products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hellodev.fakestoreapp.data.mapper.toDomain
import br.com.hellodev.fakestoreapp.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import br.com.hellodev.fakestoreapp.presenter.features.products.action.ProductsAction
import br.com.hellodev.fakestoreapp.presenter.features.products.state.ProductsState

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(ProductsState())
    var state: StateFlow<ProductsState> = _state

    init {
        getProducts()
    }

    fun dispatchAction(action: ProductsAction) {
        when (action) {
            is ProductsAction.SearchProduct -> {
                searchProduct(search = action.search)
            }

            ProductsAction.GetAllProducts -> {
                getProducts()
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

    private fun searchProduct(search: String) {
        viewModelScope.launch {
            val result = _state.value.products?.filter { it.title?.contains(search, true) == true }
            _state.value = _state.value.copy(
                isLoading = false,
                products = result
            )
        }
    }

}