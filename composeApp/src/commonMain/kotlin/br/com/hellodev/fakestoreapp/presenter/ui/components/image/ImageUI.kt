package br.com.hellodev.fakestoreapp.presenter.ui.components.image

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ImageUI(
    modifier: Modifier = Modifier,
    imageModel: Any,
    previewPlaceholder: Painter? = null,
    shape: Shape = RoundedCornerShape(12.dp),
    borderStroke: BorderStroke = BorderStroke(0.dp, Color.Transparent),
    contentScale: ContentScale = ContentScale.Crop,
) {
    CoilImage(
        imageModel = { imageModel },
        modifier = modifier
            .clip(shape = shape)
            .border(border = borderStroke, shape = shape),
        imageOptions = ImageOptions(
            contentScale = contentScale
        ),
        previewPlaceholder = previewPlaceholder,
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        },
        failure = {

        }
    )
}

@Preview
@Composable
private fun ImageUIPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        ImageUI(
//            modifier = Modifier
//                .width(250.dp)
//                .height(250.dp),
//            imageModel = "https://cinema10.c/upload/noticias/noticias-venom-pmaz3xp.jp",
//            previewPlaceholder = painterResource(id = Res.prod),
//            shape = CircleShape,
//            borderStroke = BorderStroke(0.dp, Color.Transparent),
//            onCLick = {}
//        )
    }
}