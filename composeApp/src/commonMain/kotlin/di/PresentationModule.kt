package di

import presenter.products.viewmodel.ProductsViewModel
import org.koin.dsl.module
import presenter.details.viewmodel.ProductDetailsViewModel

val presentationModule = module {

    single {
        ProductsViewModel(getProductsUseCase = get())
    }

    single {
        ProductDetailsViewModel(
            productId = get(),
            getProductByIdUseCase = get(),
            getProductsUseCase = get()
        )
    }

}