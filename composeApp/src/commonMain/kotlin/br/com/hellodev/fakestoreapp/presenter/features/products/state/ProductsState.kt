package br.com.hellodev.fakestoreapp.presenter.features.products.state

import br.com.hellodev.fakestoreapp.domain.model.Product

data class ProductsState(
    val isLoading: Boolean = true,
    val products: List<Product>? = emptyList()
)
