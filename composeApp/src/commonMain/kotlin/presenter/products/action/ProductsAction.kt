package presenter.products.action

sealed class ProductsAction {

    data class SearchProduct(val search: String): ProductsAction()

}