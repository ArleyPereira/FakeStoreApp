package br.com.hellodev.fakestoreapp

import androidx.compose.ui.window.ComposeUIViewController
import br.com.hellodev.fakestoreapp.core.app.App
import br.com.hellodev.fakestoreapp.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }