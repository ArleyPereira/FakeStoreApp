package br.com.hellodev.fakestoreapp.di

import br.com.hellodev.fakestoreapp.presenter.features.products.viewmodel.ProductsViewModel
import org.koin.dsl.module
import br.com.hellodev.fakestoreapp.presenter.features.details.viewmodel.ProductDetailsViewModel

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