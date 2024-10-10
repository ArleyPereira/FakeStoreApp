package presenter.features.products.action

sealed class ProductsAction {

    data object GetAllProducts: ProductsAction()
    data class SearchProduct(val search: String): ProductsAction()

}