package br.com.hellodev.fakestoreapp.presenter.features.products.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fakestoreapp.composeapp.generated.resources.Res
import fakestoreapp.composeapp.generated.resources.banner
import fakestoreapp.composeapp.generated.resources.ic_cart
import fakestoreapp.composeapp.generated.resources.ic_search
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import br.com.hellodev.fakestoreapp.presenter.features.products.action.ProductsAction
import br.com.hellodev.fakestoreapp.presenter.features.products.state.ProductsState
import br.com.hellodev.fakestoreapp.presenter.features.products.viewmodel.ProductsViewModel
import br.com.hellodev.fakestoreapp.presenter.ui.components.category.CategoryItemUI
import br.com.hellodev.fakestoreapp.presenter.ui.components.category.CategoryTagItemUI

@Composable
fun ProductsScreen(
    navigateToProductDetails: (Int) -> Unit,
    navigateToCart: () -> Unit
) {
    val viewModel = koinViewModel<ProductsViewModel>()
    val state = viewModel.state.collectAsState().value
    ProductsContent(
        state = state,
        action = {
            viewModel.dispatchAction(it)
        },
        navigateToProductDetails = navigateToProductDetails,
        navigateToCart = navigateToCart
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductsContent(
    state: ProductsState,
    action: (ProductsAction) -> Unit,
    navigateToProductDetails: (Int) -> Unit,
    navigateToCart: () -> Unit
) {
    val controller = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    var search by remember { mutableStateOf("") }
    var onSearched by remember { mutableStateOf(false) }
    var categoryPosition by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Hellodev",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 19.6.sp,
                            fontWeight = FontWeight.Bold,
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFFac5cfc), // #ac5cfc
                                    Color(0xFF728bfa), // #728bfa
                                    Color(0xFF00b7fc)  // #00b7fc
                                )
                            )
                        )
                    )
                },
                actions = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(
                                painter = painterResource(Res.drawable.ic_search),
                                contentDescription = null,
                                tint = Color(0xFF808080)
                            )
                        }
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = navigateToCart,
                        content = {
                            Icon(
                                painter = painterResource(Res.drawable.ic_cart),
                                contentDescription = null,
                                tint = Color(0xFF808080)
                            )
                        }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.White,
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(horizontal = 16.dp)
                   ) {
                       Image(
                           painter = painterResource(Res.drawable.banner),
                           contentDescription = null,
                       )
                   }
                }

                item {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(10) {
                            CategoryTagItemUI(
                                isChecked = it == 0,
                                onClick = {

                                }
                            )
                        }
                    }
                }

                items(5) {
                    CategoryItemUI(
                        items = state.products ?: emptyList(),
                        navigateToProductDetails = navigateToProductDetails
                    )
                }
            }
        }
    )

}

@Composable
private fun ProductsPreview() {

}