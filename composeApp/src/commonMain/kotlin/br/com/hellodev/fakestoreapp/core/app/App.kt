package br.com.hellodev.fakestoreapp.core.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import br.com.hellodev.fakestoreapp.core.navigation.hosts.AppNavHost

@Composable
fun App() {
    AppNavHost(
        navHostController = rememberNavController()
    )
}