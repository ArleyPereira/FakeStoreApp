package presenter.products.viewmodel

import data.mapper.toDomain
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import presenter.products.state.ProductsState

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(ProductsState())
    var state: StateFlow<ProductsState> = _state

    init {
        getProducts()
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

}