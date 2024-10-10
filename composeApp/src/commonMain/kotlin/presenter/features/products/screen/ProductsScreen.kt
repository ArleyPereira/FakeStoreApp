package presenter.features.products.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import presenter.features.products.action.ProductsAction
import presenter.features.products.state.ProductsState
import presenter.features.products.viewmodel.ProductsViewModel
import presenter.ui.components.product.CardProduct
import presenter.ui.components.product.ShimmerListItem

@Composable
fun ProductsScreen(
    navigateToProductDetails: (Int) -> Unit
) {
    val viewModel = koinViewModel<ProductsViewModel>()
    val state = viewModel.state.collectAsState().value
    ProductsContent(
        state = state,
        action = {
            viewModel.dispatchAction(it)
        },
        navigateToProductDetails = navigateToProductDetails
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductsContent(
    state: ProductsState,
    action: (ProductsAction) -> Unit,
    navigateToProductDetails: (Int) -> Unit
) {
    val controller = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    var search by remember { mutableStateOf("") }
    var onSearched by remember { mutableStateOf(false) }

    ShimmerListItem(
        isLoading = state.isLoading,
        contentAfterLoading = {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(12.dp)
            ) {
                item(span = { GridItemSpan(2) }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
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
                                    onSearched = true
                                    action(ProductsAction.SearchProduct(search))

                                    controller?.hide()
                                    focusManager.clearFocus()
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
                                                    onSearched = false
                                                },
                                            tint = Color.Black.copy(alpha = 0.4f)
                                        )
                                    }
                                }
                            ) {}

                            Spacer(Modifier.height(16.dp))
                        }

                        if (onSearched) {
                            Text(
                                text = "Todos",
                                modifier = Modifier
                                    .clickable {
                                        search = ""
                                        action(ProductsAction.GetAllProducts)
                                        onSearched = false

                                        controller?.hide()
                                        focusManager.clearFocus()
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                }

                items(items = state.products ?: emptyList(), key = { product ->
                    product.id.toString()
                }) { product ->
                    CardProduct(
                        product = product,
                        onProductClick = { product.id?.let(navigateToProductDetails) }
                    )
                }
            }
        }
    )

}

@Composable
private fun ProductsPreview() {

}