package presenter.details.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import domain.model.SizeProduct
import io.kamel.core.Resource
import io.kamel.core.getOrNull
import io.kamel.image.asyncPainterResource
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import presenter.details.action.ProductDetailsAction
import presenter.details.state.ProductDetailsState
import presenter.details.viewmodel.ProductDetailsViewModel
import ui.components.product.CardProduct
import ui.components.product.ProductColorUI
import ui.components.product.SizeOptionProduct

data class ProductDetailsScreen(
    val productId: Int
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel =
            koinInject<ProductDetailsViewModel>(parameters = { parametersOf(productId) })
        val state = viewModel.state.collectAsState().value
        ProductDetailsContent(
            state = state,
            action = { viewModel.dispatchAction(it) },
            onBackPressed = { navigator.pop() },
        )
    }
}

@Composable
fun ProductDetailsContent(
    state: ProductDetailsState,
    action: (ProductDetailsAction) -> Unit,
    onBackPressed: () -> Unit
) {
    var sizeIsSelected by remember {
        mutableIntStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        val painterResource: Resource<Painter> =
            asyncPainterResource(state.product?.image.toString())
        painterResource.getOrNull()?.let { painter ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painter,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .background(Color.Black),
                    contentScale = ContentScale.Crop
                )

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black.copy(alpha = 0.05f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(8.dp)
                        .clickable { onBackPressed() }
                )

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp)
                        .align(Alignment.BottomCenter),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier
                            .height(40.dp)
                            .width(50.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFFC6E20),
                                shape = RoundedCornerShape(12.dp)
                            )
                    )

                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier
                            .height(40.dp)
                            .width(50.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFFC6E20),
                                shape = RoundedCornerShape(12.dp)
                            )
                    )

                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier
                            .height(40.dp)
                            .width(50.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFFC6E20),
                                shape = RoundedCornerShape(12.dp)
                            )
                    )

                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier
                            .height(40.dp)
                            .width(50.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFFC6E20),
                                shape = RoundedCornerShape(12.dp)
                            )
                    )
                }
            }
        }

        Text(
            text = (state.product?.title ?: "").uppercase(),
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tamanhos",
            modifier = Modifier
                .padding(start = 16.dp),
            fontWeight = FontWeight.SemiBold
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(items = SizeProduct.getSizeOptions(), key = { it.id ?: 0 }) { option ->
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
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.product?.colors ?: emptyList()) { color ->
                ProductColorUI(
                    productColor = color,
                    onColorSelected = { colorId ->
                        action(ProductDetailsAction.SelectProductColor(colorId))
                    },
                    isSelected = state.productColorSelected == color
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        state.product?.description?.let { description ->
            Text(
                text = "Descrição",
                modifier = Modifier
                    .padding(start = 16.dp),
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                modifier = Modifier
                    .padding(start = 16.dp),
                color = Color.Black.copy(alpha = 0.4f),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        state.products?.let { products ->
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Relacionados",
                modifier = Modifier
                    .padding(start = 16.dp),
                fontWeight = FontWeight.SemiBold
            )

            LazyRow(
                content = {
                    items(
                        items = products,
                        key = { it.id ?: 0 }
                    ) { product ->
                        CardProduct(
                            modifier = Modifier
                                .width(180.dp),
                            product = product,
                            onProductClick = {}
                        )
                    }
                }
            )
        }
    }
}