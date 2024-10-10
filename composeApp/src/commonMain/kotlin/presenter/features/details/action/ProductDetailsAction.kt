package presenter.features.details.action

sealed class ProductDetailsAction {

    data class SelectProductColor(val colorId: Int?) : ProductDetailsAction()

}