package di

import data.repository.HomeRepositoryImpl
import domain.repository.HomeRepository
import org.koin.dsl.module

val dataModule = module {

    single<HomeRepository> {
        HomeRepositoryImpl(httpClient = get())
    }

}