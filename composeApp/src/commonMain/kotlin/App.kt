import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.ProductResponse
import domain.model.Product
import io.kamel.core.Resource
import io.kamel.core.getOrNull
import io.kamel.image.asyncPainterResource
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun App() {
    KoinContext {
        MaterialTheme {
            AppContent(homeViewModel = koinInject<HomeViewModel>())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(homeViewModel: HomeViewModel) {
    val products = homeViewModel.products.collectAsState().value
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp)
    ) {

        item(span = { GridItemSpan(2) }) {
            Column {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth(),
                    query = "",
                    active = false,
                    onActiveChange = {},
                    onQueryChange = {},
                    onSearch = {},
                    placeholder = {
                        Text(
                            text = "Search products",
                            color = Color.Black.copy(alpha = 0.4f)
                        )
                    }
                ) {}

                Spacer(Modifier.height(16.dp))
            }
        }

        items(items = products, key = { product ->
            product.id.toString()
        }) { product ->
            CardProduct(product = product)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardProduct(
    modifier: Modifier = Modifier,
    product: Product
) {
    Card(
        onClick = { },
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
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val painterResource: Resource<Painter> = asyncPainterResource(product.image.toString())
            painterResource.getOrNull()?.let { painter ->

                Image(
                    painter = painter,
                    contentDescription = "",
                    modifier = Modifier
                        .height(130.dp)
                        .padding(8.dp)
                )
            }

            Text(
                text = product.title ?: "",
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .heightIn(min = 40.dp),
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}