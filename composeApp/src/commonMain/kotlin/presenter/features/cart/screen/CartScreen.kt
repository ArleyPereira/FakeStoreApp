package presenter.features.cart.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import fakestoreapp.composeapp.generated.resources.ic_arrow_down
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presenter.ui.components.DashedDivider
import presenter.ui.components.bar.top.TopAppBarUI

@Composable
fun CartScreen(
    onBackPressed: () -> Unit
) {
    CartContent(
        onBackPressed = onBackPressed
    )
}

@Composable
private fun CartContent(
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarUI(
                text = "Carrinho",
                onClick = onBackPressed
            )
        },
        containerColor = Color.White,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                DashedDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Entregar para ",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 14.4.sp,
                                color = Color(0xFF808080)
                            )
                        )

                        Text(
                            text = "Guilherme",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 14.4.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF808080)
                            )
                        )

                        Icon(
                            painter = painterResource(Res.drawable.ic_arrow_down),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }

                    Text(
                        text = "Vila Gondim, Icó/CE",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            color = Color(0xFF00B7FC)
                        )
                    )
                }

                DashedDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    )
}

@Preview
@Composable
private fun CartPreview() {
    CartContent(
        onBackPressed = {}
    )
}