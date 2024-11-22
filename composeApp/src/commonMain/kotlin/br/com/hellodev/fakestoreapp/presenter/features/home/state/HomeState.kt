package br.com.hellodev.fakestoreapp.presenter.features.home.state

import br.com.hellodev.fakestoreapp.domain.model.Product

data class HomeState(
    val isLoading: Boolean = true,
    val products: List<Product>? = emptyList(),
    val categories: List<String>? = emptyList()
)
