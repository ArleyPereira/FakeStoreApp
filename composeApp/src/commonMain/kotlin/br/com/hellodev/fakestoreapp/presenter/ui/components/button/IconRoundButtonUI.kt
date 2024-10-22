package br.com.hellodev.fakestoreapp.presenter.ui.components.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun IconRoundButtonUI(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color(0xFFF2F2F2),
                shape = CircleShape
            )
            .size(32.dp),
        enabled = enabled,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Transparent
        ),
        content = {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    )
}

@Preview
@Composable
private fun IconRoundButtonUIPreview() {
    IconButtonUI(
        text = "Adicionar ao carrinho",
        onClick = {}
    )
}