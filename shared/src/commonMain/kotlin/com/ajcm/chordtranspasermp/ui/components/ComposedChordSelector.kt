package com.ajcm.chordtranspasermp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ajcm.chordtranspasermp.transpaser.Chord
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class, ExperimentalResourceApi::class)
@Composable
fun ComposedChordSelector(
    modifier: Modifier,
    chord: String,
    composedChordSelected: (String) -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.large,
        shadowElevation = 0.dp,
        color = MaterialTheme.colorScheme.tertiaryContainer,
        modifier = modifier
    ) {

        val selectedChords = Chord.compositions[chord]?.map { composition ->
            chord + composition
        } ?: emptyList()

        Column {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                IconRes(
                    stringPath = "drawable/arrow_back.png",
                    colorTint = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            composedChordSelected("")
                        }
                )

                Text(
                    text = "Selecciona su variante",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            FlowRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
                maxItemsInEachRow = 5,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 16.dp)
            ) {
                selectedChords.forEach { chord ->
                    ChordItem(value = chord) { c ->
                        composedChordSelected(c)
                    }
                }
            }
        }
    }
}
