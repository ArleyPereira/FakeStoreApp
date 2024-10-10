package presenter.features.details.state

import domain.model.Product
import domain.model.ProductColor

data class ProductDetailsState(
    val isLoading: Boolean = true,
    val product: Product? = null,
    val productColorSelected: ProductColor? = null,
    val products: List<Product>? = null
)
