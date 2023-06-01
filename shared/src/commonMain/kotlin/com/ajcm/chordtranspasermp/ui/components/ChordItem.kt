package com.ajcm.chordtranspasermp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ChordItem(value: String, modifier: Modifier, onClick: (String) -> Unit) {
    Surface(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick(value) },
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.85f)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onTertiary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
