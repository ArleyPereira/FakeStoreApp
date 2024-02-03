package presenter.details.action

sealed class ProductDetailsAction {

    data class SelectProductColor(val colorId: Int?) : ProductDetailsAction()

}