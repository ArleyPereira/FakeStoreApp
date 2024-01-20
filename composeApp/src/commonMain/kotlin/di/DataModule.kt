package di

import data.repository.HomeRepository
import org.koin.dsl.module

val dataModule = module {

    single {
        HomeRepository(httpClient = get())
    }

}