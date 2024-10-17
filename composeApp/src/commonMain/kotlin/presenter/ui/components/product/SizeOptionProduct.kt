package presenter.ui.components.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.SizeProduct

@Composable
fun SizeOptionProduct(
    option: SizeProduct,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onSizeSelected: (Int) -> Unit
) {
    Card(
        onClick = { onSizeSelected(option.id ?: 0) },
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF00B7FC) else Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(0.dp),
        border = BorderStroke(
            width = if (isSelected) 0.dp else 1.dp,
            color = Color(0xFFEBEBEB)
        ),
        content = {
            option.name?.let { name ->
                Text(
                    text = name,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 12.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.4.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isSelected) Color.White else Color(0xFF31363F),
                        textAlign = TextAlign.Center
                    )
                )
            }
        },
    )
}