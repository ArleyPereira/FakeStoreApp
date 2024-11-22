package br.com.hellodev.fakestoreapp.presenter.features.home.action

sealed class HomeAction {

    data object GetAllHome: HomeAction()
    data class SearchProduct(val search: String): HomeAction()

}