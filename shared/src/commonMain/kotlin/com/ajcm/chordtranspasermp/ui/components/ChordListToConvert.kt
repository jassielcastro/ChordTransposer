package com.ajcm.chordtranspasermp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ajcm.chordtranspasermp.transpaser.ChordConverter

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChordListToConvert(
    list: () -> List<String>
) {

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {

        var currentSemiTone by remember {
            mutableStateOf(0)
        }

        Surface(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {

            IconRes(
                stringPath = "drawable/graph_1.png",
                colorTint = MaterialTheme.colorScheme.tertiaryContainer,
                alpha = 0.35f,
                modifier = Modifier
                    .size(500.dp)
            )

            Column {

                Text(
                    text = if (currentSemiTone != 0) "Cambio de semitono en: $currentSemiTone" else "Semitono sin cambio",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                FlowRow(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                    maxItemsInEachRow = 4,
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    list.invoke().forEach { chord ->
                        ConvertionChordItem(
                            current = chord,
                            convertion = ChordConverter.transform(chord, currentSemiTone)
                        )
                    }
                }
            }
        }

        ConverterButtons(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically)
        ) { semiTone ->
            currentSemiTone += semiTone
        }
    }
}
