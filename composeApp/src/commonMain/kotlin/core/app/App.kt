package core.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import core.navigation.hosts.AppNavHost
import org.koin.compose.KoinContext

@Composable
fun App() {
    KoinContext {
        MaterialTheme {
            AppNavHost(navHostController = rememberNavController())
        }
    }
}