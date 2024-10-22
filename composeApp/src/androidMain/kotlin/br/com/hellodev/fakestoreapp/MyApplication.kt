package br.com.hellodev.fakestoreapp

import android.app.Application
import br.com.hellodev.fakestoreapp.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin {
            androidContext(this@MyApplication)
        }
    }

}