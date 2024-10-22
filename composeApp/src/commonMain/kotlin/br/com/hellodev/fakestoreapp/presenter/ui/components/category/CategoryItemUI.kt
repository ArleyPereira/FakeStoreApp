package br.com.hellodev.fakestoreapp.presenter.ui.components.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.hellodev.fakestoreapp.domain.model.Product
import org.jetbrains.compose.ui.tooling.preview.Preview
import br.com.hellodev.fakestoreapp.presenter.ui.components.product.CardProduct

@Composable
fun CategoryItemUI(
    modifier: Modifier = Modifier,
    items: List<Product>,
    navigateToProductDetails: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Tênis",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF31363F)
                )
            )

            Text(
                text = "ver tudo",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF31363F),
                    textDecoration = TextDecoration.Underline
                )
            )
        }

        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(
                    items = items,
                    key = { it.id ?: 0 }
                ) { product ->
                    CardProduct(
                        modifier = Modifier
                            .width(160.dp),
                        product = product,
                        onProductClick = {
                            product.id?.let(navigateToProductDetails)
                        }
                    )
                }
            }
        )
    }
}

@Preview
@Composable
private fun CategoryItemUIPreview(
    modifier: Modifier = Modifier
) {
    CategoryItemUI(
        items = listOf(),
        navigateToProductDetails = {}
    )
}