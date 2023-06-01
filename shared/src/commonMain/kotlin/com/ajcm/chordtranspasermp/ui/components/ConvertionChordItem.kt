package com.ajcm.chordtranspasermp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ConvertionChordItem(
    current: String,
    convertion: String
) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 8.dp)
            .wrapContentSize()
            .border(
                BorderStroke(2.dp, MaterialTheme.colorScheme.onTertiaryContainer),
                MaterialTheme.shapes.medium
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = current,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .wrapContentWidth()
        )

        IconRes(
            stringPath = "drawable/trending_flat.png",
            colorTint = MaterialTheme.colorScheme.onTertiaryContainer,
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .widthIn(max = 18.dp)
        )

        Text(
            text = convertion,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .wrapContentWidth()
        )
    }
}
