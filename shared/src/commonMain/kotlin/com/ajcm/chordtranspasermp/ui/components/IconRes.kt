package com.ajcm.chordtranspasermp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.ajcm.chordtranspasermp.toImageBitmap
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun IconRes(
    stringPath: String,
    colorTint: Color,
    alpha: Float = 1f,
    contentScale: ContentScale = ContentScale.Crop,
    modifier: Modifier
) {
    var image by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(Unit) {
        runCatching {
            resource(stringPath).readBytes().toImageBitmap()
        }.onSuccess { bitmap ->
            image = bitmap
        }
    }

    image?.let {
        Image(
            it,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(colorTint),
            alpha = alpha,
            modifier = modifier
        )
    } ?: Spacer(modifier)
}
