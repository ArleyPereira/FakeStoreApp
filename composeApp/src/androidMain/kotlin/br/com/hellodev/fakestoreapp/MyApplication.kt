package br.com.hellodev.fakestoreapp

import android.app.Application
import di.dataModule
import di.domainModule
import di.networkModule
import di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            androidLogger()

            modules(
                listOf(
                    domainModule,
                    networkModule,
                    presentationModule,
                    dataModule
                )
            )
        }
    }

}