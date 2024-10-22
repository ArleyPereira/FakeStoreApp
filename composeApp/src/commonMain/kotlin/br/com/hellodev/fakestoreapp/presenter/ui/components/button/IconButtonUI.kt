package br.com.hellodev.fakestoreapp.presenter.ui.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fakestoreapp.composeapp.generated.resources.Res
import fakestoreapp.composeapp.generated.resources.ic_cart
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun IconButtonUI(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF00B7FC)
        ),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        lineHeight = 14.4.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.width(12.dp))

                Icon(
                    painter = painterResource(Res.drawable.ic_cart),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
    )
}

@Preview
@Composable
private fun IconButtonUIPreview() {
    IconButtonUI(
        text = "Adicionar ao carrinho",
        onClick = {}
    )
}