package br.com.hellodev.fakestoreapp.presenter.features.details.state

import br.com.hellodev.fakestoreapp.domain.model.Product
import br.com.hellodev.fakestoreapp.domain.model.ProductColor

data class ProductDetailsState(
    val isLoading: Boolean = true,
    val product: Product? = null,
    val productColorSelected: ProductColor? = null,
    val products: List<Product>? = null
)
