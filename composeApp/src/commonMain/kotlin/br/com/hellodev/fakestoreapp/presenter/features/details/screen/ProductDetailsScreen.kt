package br.com.hellodev.fakestoreapp.presenter.features.details.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.hellodev.fakestoreapp.domain.model.SizeProduct
import fakestoreapp.composeapp.generated.resources.Res
import fakestoreapp.composeapp.generated.resources.ic_arrow_left
import fakestoreapp.composeapp.generated.resources.ic_share
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import br.com.hellodev.fakestoreapp.presenter.features.details.action.ProductDetailsAction
import br.com.hellodev.fakestoreapp.presenter.features.details.state.ProductDetailsState
import br.com.hellodev.fakestoreapp.presenter.features.details.viewmodel.ProductDetailsViewModel
import br.com.hellodev.fakestoreapp.presenter.ui.components.button.IconButtonUI
import br.com.hellodev.fakestoreapp.presenter.ui.components.image.ImageUI
import br.com.hellodev.fakestoreapp.presenter.ui.components.product.CardProduct
import br.com.hellodev.fakestoreapp.presenter.ui.components.product.ProductColorUI
import br.com.hellodev.fakestoreapp.presenter.ui.components.product.SizeOptionProduct

@Composable
fun ProductDetailsScreen(
    navigateToCartScreen: () -> Unit,
    onBackPressed: () -> Unit
) {
    val viewModel = koinViewModel<ProductDetailsViewModel>()
    val state by viewModel.state.collectAsState()
    ProductDetailsContent(
        uiState = state,
        action = { viewModel.dispatchAction(it) },
        navigateToCartScreen = navigateToCartScreen,
        onBackPressed = onBackPressed
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductDetailsContent(
    uiState: ProductDetailsState,
    action: (ProductDetailsAction) -> Unit,
    navigateToCartScreen: () -> Unit,
    onBackPressed: () -> Unit
) {
    var sizeIsSelected by remember {
        mutableIntStateOf(1)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = {
                    Text(
                        text = "Home",
                        style = TextStyle(
                            lineHeight = 16.8.sp,
                            color = Color(0xFF808080)
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed,
                        content = {
                            Icon(
                                painter = painterResource(Res.drawable.ic_arrow_left),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                    )
                },
                actions = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(
                                painter = painterResource(Res.drawable.ic_share),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .windowInsetsPadding(WindowInsets.navigationBars)
            ) {
                IconButtonUI(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "Adicionar ao carrinho",
                    onClick = navigateToCartScreen
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(
                        bottom = paddingValues.calculateBottomPadding()
                    )
                    .verticalScroll(rememberScrollState())
            ) {
                ImageUI(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp),
                    imageModel = uiState.product?.image ?: "",
                    contentScale = ContentScale.Crop,
                    shape = RoundedCornerShape(0.dp)
                )

                Text(
                    text = uiState.product?.title ?: "",
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 19.6.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF808080)
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Tamanhos",
                    modifier = Modifier
                        .padding(start = 16.dp),
                    style = TextStyle(
                        lineHeight = 19.6.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF31363F)
                    )
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(
                            items = SizeProduct.getSizeOptions(),
                            key = { it.id ?: 0 }) { option ->
                            SizeOptionProduct(
                                option = option,
                                isSelected = sizeIsSelected == option.id,
                                onSizeSelected = { optionId ->
                                    sizeIsSelected = optionId
                                }
                            )
                        }
                    }
                )

                Text(
                    text = "Cores",
                    modifier = Modifier
                        .padding(start = 16.dp),
                    style = TextStyle(
                        lineHeight = 19.6.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF31363F)
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.product?.colors ?: emptyList()) { color ->
                        ProductColorUI(
                            productColor = color,
                            onColorSelected = { colorId ->
                                action(ProductDetailsAction.SelectProductColor(colorId))
                            },
                            isSelected = uiState.productColorSelected == color
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                uiState.product?.description?.let { description ->
                    Text(
                        text = "Descrição",
                        modifier = Modifier
                            .padding(start = 16.dp),
                        style = TextStyle(
                            lineHeight = 19.6.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF31363F)
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = description,
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
                            color = Color(0xFF596273)
                        )
                    )
                }

                uiState.products?.let { products ->
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Relacionados",
                        modifier = Modifier
                            .padding(start = 16.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                    LazyRow(
                        contentPadding = PaddingValues(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        content = {
                            items(
                                items = products.shuffled(),
                                key = { it.id ?: 0 }
                            ) { product ->
                                CardProduct(
                                    modifier = Modifier
                                        .width(160.dp),
                                    product = product,
                                    onProductClick = {}
                                )
                            }
                        }
                    )
                }
            }
        }
    )
}

@Composable
private fun ProductDetailsPreview() {

}