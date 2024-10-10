package di

import presenter.features.products.viewmodel.ProductsViewModel
import org.koin.dsl.module
import presenter.features.details.viewmodel.ProductDetailsViewModel

val presentationModule = module {

    single {
        ProductsViewModel(getProductsUseCase = get())
    }

    single {
        ProductDetailsViewModel(
            getProductByIdUseCase = get(),
            getProductsUseCase = get(),
            savedStateHandle = get()
        )
    }

}