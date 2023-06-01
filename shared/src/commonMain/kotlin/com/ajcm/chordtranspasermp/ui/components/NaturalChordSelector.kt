package com.ajcm.chordtranspasermp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NaturalChordSelector(
    modifier: Modifier,
    chordSelected: (String) -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.large,
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.tertiaryContainer,
        modifier = modifier
    ) {

        val selectedChords = Chord.compositions.keys.toList()

        Box {

            IconRes(
                stringPath = "drawable/waves.png",
                colorTint = MaterialTheme.colorScheme.background.copy(alpha = 0.6f),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Selecciona el acorde",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                )

                FlowRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                    maxItemsInEachRow = 4,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    selectedChords.forEach { chord ->
                        ChordItem(
                            value = chord,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .weight(1f, true)
                        ) { c ->
                            chordSelected(c)
                        }
                    }
                }
            }
        }


    }
}
