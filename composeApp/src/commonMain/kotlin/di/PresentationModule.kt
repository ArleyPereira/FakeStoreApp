package di

import presenter.products.viewmodel.ProductsViewModel
import org.koin.dsl.module

val presentationModule = module {

    single {
        ProductsViewModel(getProductsUseCase = get())
    }

}