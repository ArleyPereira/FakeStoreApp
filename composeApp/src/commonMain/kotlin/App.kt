import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.koin.compose.KoinContext
import presenter.products.view.ProductsScreen

@Composable
fun App() {
    KoinContext {
        MaterialTheme {
            ProductsScreen()
        }
    }
}