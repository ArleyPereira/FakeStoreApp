package di

import domain.usecase.GetProductByIdUseCase
import domain.usecase.GetProductsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetProductsUseCase(repository = get())
    }

    factory {
        GetProductByIdUseCase(repository = get())
    }

}