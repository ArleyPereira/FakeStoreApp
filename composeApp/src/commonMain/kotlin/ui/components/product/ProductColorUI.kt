package ui.components.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import domain.model.ProductColor
import util.parseColor

@Composable
fun ProductColorUI(
    modifier: Modifier = Modifier,
    productColor: ProductColor,
    isSelected: Boolean,
    onColorSelected: (Int) -> Unit
) {
    Box(
        modifier = modifier
            .size(30.dp)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) {
                productColor.id?.let { onColorSelected(productColor.id) }
            }
    ) {
        Spacer(
            modifier = modifier
                .size(18.dp)
                .background(shape = CircleShape, color = productColor.color.parseColor())
                .align(Alignment.Center)
        )

        Spacer(
            modifier = modifier
                .size(30.dp)
                .background(
                    shape = CircleShape,
                    color = productColor.color.parseColor().copy(alpha = 0.2f)
                )
                .align(Alignment.Center)
        )

        if (isSelected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                modifier = Modifier
                    .size(12.dp)
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
    }

}