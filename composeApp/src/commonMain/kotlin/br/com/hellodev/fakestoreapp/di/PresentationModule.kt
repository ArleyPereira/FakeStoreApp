package br.com.hellodev.fakestoreapp.di

import br.com.hellodev.fakestoreapp.presenter.features.home.viewmodel.HomeViewModel
import org.koin.dsl.module
import br.com.hellodev.fakestoreapp.presenter.features.details.viewmodel.ProductDetailsViewModel

val presentationModule = module {

    single {
        HomeViewModel(getProductsUseCase = get())
    }

    single {
        ProductDetailsViewModel(
            getProductByIdUseCase = get(),
            getProductsUseCase = get(),
            savedStateHandle = get()
        )
    }

}