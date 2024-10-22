package br.com.hellodev.fakestoreapp.di

import br.com.hellodev.fakestoreapp.data.database.getDatabaseBuilder
import org.koin.dsl.module

actual val targetModule = module {
    single { getDatabaseBuilder() }
}