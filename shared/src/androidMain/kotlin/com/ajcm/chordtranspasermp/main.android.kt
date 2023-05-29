package com.ajcm.chordtranspasermp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.ajcm.chordtranspasermp.android.R
import com.ajcm.chordtranspasermp.ui.MainScreen

@Composable
fun MainView() = MainScreen()

actual val montserratFontFamily: FontFamily = FontFamily(
    Font(R.font.montserrat)
)

actual val righteousFontFamily: FontFamily = FontFamily(
    Font(R.font.righteous_regular)
)

actual fun ByteArray.toImageBitmap(): ImageBitmap = toAndroidBitmap().asImageBitmap()

fun ByteArray.toAndroidBitmap(): Bitmap {
    return BitmapFactory.decodeByteArray(this, 0, size)
}
