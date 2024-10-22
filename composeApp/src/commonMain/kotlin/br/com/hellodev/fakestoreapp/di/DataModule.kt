package br.com.hellodev.fakestoreapp.di

import br.com.hellodev.fakestoreapp.data.repository.HomeRepositoryImpl
import br.com.hellodev.fakestoreapp.domain.repository.HomeRepository
import org.koin.dsl.module

val dataModule = module {

    single<HomeRepository> {
        HomeRepositoryImpl(httpClient = get())
    }

}