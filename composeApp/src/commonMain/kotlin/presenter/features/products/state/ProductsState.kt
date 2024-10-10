package presenter.features.products.state

import domain.model.Product

data class ProductsState(
    val isLoading: Boolean = true,
    val products: List<Product>? = emptyList()
)
