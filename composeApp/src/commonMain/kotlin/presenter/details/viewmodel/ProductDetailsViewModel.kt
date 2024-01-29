package presenter.details.viewmodel

import data.mapper.toDomain
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.usecase.GetProductByIdUseCase
import domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import presenter.details.action.ProductDetailsAction
import presenter.details.state.ProductDetailsState

class ProductDetailsViewModel(
    productId: Int?,
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(ProductDetailsState())
    var state: StateFlow<ProductDetailsState> = _state

    init {
        getProduct(productId)
        getProducts()
    }

    fun dispatchAction(action: ProductDetailsAction) {

    }

    private fun getProduct(productId: Int?) {
        viewModelScope.launch {
            getProductByIdUseCase(productId).collectLatest { product ->
                _state.value = _state.value.copy(
                    isLoading = false,
                    product = product.toDomain()
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

}