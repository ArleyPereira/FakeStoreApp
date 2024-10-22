package br.com.hellodev.fakestoreapp.di

import br.com.hellodev.fakestoreapp.domain.usecase.GetProductByIdUseCase
import br.com.hellodev.fakestoreapp.domain.usecase.GetProductsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetProductsUseCase(repository = get())
    }

    factory {
        GetProductByIdUseCase(repository = get())
    }

}