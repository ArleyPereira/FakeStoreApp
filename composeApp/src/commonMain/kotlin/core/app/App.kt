package core.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import core.navigation.hosts.AppNavHost

@Composable
fun App() {
    AppNavHost(
        navHostController = rememberNavController()
    )
}