package presenter.details.state

import domain.model.Product

data class ProductDetailsState(
    val isLoading: Boolean = true,
    val product: Product? = null,
    val products: List<Product>? = null
)
