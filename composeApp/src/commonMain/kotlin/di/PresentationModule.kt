package di

import HomeViewModel
import org.koin.dsl.module

val presentationModule = module {

    single {
        HomeViewModel(getProductsUseCase = get())
    }

}