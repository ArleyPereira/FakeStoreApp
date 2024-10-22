package br.com.hellodev.fakestoreapp.presenter.ui.components.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fakestoreapp.composeapp.generated.resources.Res
import fakestoreapp.composeapp.generated.resources.ic_stars
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CategoryTagItemUI(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isChecked) {
        Color(0xFF00B7FC)
    } else {
        Color(0xFFEBEBEB)
    }

    val backgroundColor = if (isChecked) {
        Color(0xFF00B7FC)
    } else {
        Color.Transparent
    }

    val textColor = if (isChecked) {
        Color.White
    } else {
        Color(0xFF9E9E9E)
    }

    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = CircleShape
            )
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 12.dp,
                    vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isChecked) {
                Icon(
                    painter = painterResource(Res.drawable.ic_stars),
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp),
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(
                text = "Games",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 14.4.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Preview
@Composable
private fun CategoryTagItemUIPreview() {

}