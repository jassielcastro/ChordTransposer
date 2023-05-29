package com.ajcm.chordtranspasermp

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Typeface
import androidx.compose.ui.window.ComposeUIViewController
import com.ajcm.chordtranspasermp.ui.MainScreen
import org.jetbrains.skia.FontStyle
import org.jetbrains.skia.Image
import org.jetbrains.skia.Typeface as STypeface

fun MainViewController() = ComposeUIViewController { MainScreen() }

actual fun ByteArray.toImageBitmap(): ImageBitmap =
    Image.makeFromEncoded(this).toComposeImageBitmap()

actual val montserratFontFamily: FontFamily = FontFamily(
    Typeface(
        STypeface.makeFromName("montserrat.ttf", FontStyle.NORMAL)
    )
)

actual val righteousFontFamily: FontFamily = FontFamily(
    Typeface(
        STypeface.makeFromName("righteous_regular.ttf", FontStyle.NORMAL)
    )
)
