package presenter.ui.components.bar.top

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import fakestoreapp.composeapp.generated.resources.Res
import fakestoreapp.composeapp.generated.resources.ic_arrow_left
import fakestoreapp.composeapp.generated.resources.ic_cart
import fakestoreapp.composeapp.generated.resources.ic_share
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarUI(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {},
        modifier = modifier,
        actions = {
            IconButton(
                onClick = {},
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_cart),
                        contentDescription = null,
                        tint = Color(0xFF808080)
                    )
                }
            )
        },
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onClick,
                    content = {
                        Icon(
                            painter = painterResource(Res.drawable.ic_arrow_left),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                )

                Text(
                    text = "Produto",
                    style = TextStyle(
                        lineHeight = 16.8.sp,
                        color = Color(0xFF808080)
                    )
                )
            }
        }
    )
}

@Preview
@Composable
fun TopAppBarUIPreview() {
    Scaffold(
        topBar = {
            TopAppBarUI(
                text = "Preview",
                onClick = {}
            )
        },
        content = { paddingValues ->

        }
    )
}