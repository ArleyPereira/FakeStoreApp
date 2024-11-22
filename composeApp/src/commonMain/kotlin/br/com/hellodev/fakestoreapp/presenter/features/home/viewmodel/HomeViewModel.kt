package br.com.hellodev.fakestoreapp.presenter.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hellodev.fakestoreapp.data.mapper.toDomain
import br.com.hellodev.fakestoreapp.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import br.com.hellodev.fakestoreapp.presenter.features.home.action.HomeAction
import br.com.hellodev.fakestoreapp.presenter.features.home.state.HomeState

class HomeViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(HomeState())
    var state: StateFlow<HomeState> = _state

    init {
        getProducts()
    }

    fun dispatchAction(action: HomeAction) {
        when (action) {
            is HomeAction.SearchProduct -> {
                searchProduct(search = action.search)
            }

            HomeAction.GetAllHome -> {
                getProducts()
            }
        }
    }

    private fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase().collectLatest { products ->
                _state.value = _state.value.copy(
                    isLoading = false,
                    products = products.map { it.toDomain() },
                    categories = getCategories()
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

    private fun getCategories(): List<String> {
        return listOf(
            "Todos",
            "Masculino",
            "Feminino",
            "Infantil",
            "Cançados",
            "Roupas",
            "Suplementos",
            "Games",
            "Equipamentos"
        )
    }

}