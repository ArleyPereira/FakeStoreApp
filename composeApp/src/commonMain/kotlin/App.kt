import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.koin.compose.KoinContext
import presenter.products.view.ProductsScreen

@Composable
fun App() {
    KoinContext {
        MaterialTheme {
            Navigator(screen = ProductsScreen())
            { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}