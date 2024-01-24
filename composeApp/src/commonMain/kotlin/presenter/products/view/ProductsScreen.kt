package presenter.products.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.compose.koinInject
import presenter.details.view.ProductDetailsScreen
import presenter.products.action.ProductsAction
import presenter.products.state.ProductsState
import presenter.products.viewmodel.ProductsViewModel
import ui.components.product.CardProduct

class ProductsScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: ProductsViewModel = koinInject<ProductsViewModel>()
        val state = viewModel.state.collectAsState().value
        ProductsContent(
            state = state,
            action = {
                viewModel.dispatchAction(it)
            },
            onProductClick = {
                navigator.push(ProductDetailsScreen(it))
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsContent(
    state: ProductsState,
    action: (ProductsAction) -> Unit,
    onProductClick: (Int) -> Unit
) {
    var search by remember { mutableStateOf("") }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp)
    ) {
        item(span = { GridItemSpan(2) }) {
            Column {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth(),
                    query = search,
                    active = false,
                    onActiveChange = {
                    },
                    onQueryChange = {
                        search = it
                    },
                    onSearch = {
                        action(ProductsAction.SearchProduct(search))
                    },
                    placeholder = {
                        Text(
                            text = "Pesquisar produtos",
                            color = Color.Black.copy(alpha = 0.4f)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.Black.copy(alpha = 0.4f)
                        )
                    },
                    trailingIcon = {
                        if (search.isNotEmpty()) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "",
                                modifier = Modifier
                                    .clickable {
                                        search = ""
                                        action(ProductsAction.GetAllProducts)
                                    },
                                tint = Color.Black.copy(alpha = 0.4f)
                            )
                        }
                    }
                ) {}

                Spacer(Modifier.height(16.dp))
            }
        }
        items(items = state.products ?: emptyList(), key = { product ->
            product.id.toString()
        }) { product ->
            CardProduct(
                product = product,
                onProductClick = { product.id?.let(onProductClick) }
            )
        }
    }
}