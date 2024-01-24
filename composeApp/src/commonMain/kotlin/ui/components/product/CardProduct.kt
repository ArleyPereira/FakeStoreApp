package ui.components.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.Product
import io.kamel.core.Resource
import io.kamel.core.getOrNull
import io.kamel.image.asyncPainterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardProduct(
    modifier: Modifier = Modifier,
    product: Product,
    onProductClick: () -> Unit
) {
    Card(
        onClick = onProductClick,
        modifier = modifier
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val painterResource: Resource<Painter> = asyncPainterResource(product.image.toString())
            painterResource.getOrNull()?.let { painter ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(Color(0xFFF5F5F5))
                ) {
                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier
                            .height(130.dp)
                            .padding(8.dp)
                            .align(Alignment.Center)
                            .clip(shape = RoundedCornerShape(12.dp)),
                    )

                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp)
                            .clickable {

                            },
                        tint = Color.Black.copy(alpha = 0.4f)
                    )

                    Text(
                        text = "30% OFF",
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopStart)
                            .background(
                                color = Color(0xFFEFE9F4),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        color = Color.Black,
                        fontSize = 10.sp,
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.title ?: "",
                color = Color(0xFF515151),
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "R$ ${product.price.toString().replace(".", ",")}",
                    color = Color(0xFF515151),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(4.dp)
                        .size(20.dp)
                        .clickable {

                        },
                    tint = Color.Black.copy(alpha = 0.8f)
                )
            }
        }
    }

}