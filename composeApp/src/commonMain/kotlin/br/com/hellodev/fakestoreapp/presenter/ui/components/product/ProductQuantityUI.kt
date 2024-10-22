package br.com.hellodev.fakestoreapp.presenter.ui.components.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.hellodev.fakestoreapp.presenter.ui.components.button.IconRoundButtonUI
import fakestoreapp.composeapp.generated.resources.Res
import fakestoreapp.composeapp.generated.resources.ic_add
import fakestoreapp.composeapp.generated.resources.ic_minus
import fakestoreapp.composeapp.generated.resources.ic_remove
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ProductQuantityUI(
    modifier: Modifier = Modifier,
    onIncrementClick: () -> Unit,
    onDecrementClick: () -> Unit
) {
    Row(
        modifier = modifier
            .background(
                color = Color.White,
                shape = CircleShape
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconRoundButtonUI(
            icon = painterResource(Res.drawable.ic_minus),
            onClick = {}
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "1",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 20.sp,
                color = Color(0xFF31363F)
            )
        )

        Spacer(modifier = Modifier.width(16.dp))

        IconRoundButtonUI(
            icon = painterResource(Res.drawable.ic_add),
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun ProductQuantityUIPreview() {
    ProductQuantityUI(
        onIncrementClick = {},
        onDecrementClick = {},
    )
}