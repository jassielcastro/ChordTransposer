package com.ajcm.chordtranspasermp.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajcm.chordtranspasermp.theme.ChordConverterAppTheme
import com.ajcm.chordtranspasermp.ui.components.ChordListToConvert
import com.ajcm.chordtranspasermp.ui.components.ComposedChordSelector
import com.ajcm.chordtranspasermp.ui.components.EmptyChords
import com.ajcm.chordtranspasermp.ui.components.IconRes
import com.ajcm.chordtranspasermp.ui.components.NaturalChordSelector

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    ChordConverterAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        ) {

            var chordsToConvertList by remember {
                mutableStateOf(listOf<String>())
            }

            var selectionState by remember {
                mutableStateOf<SelectionState>(SelectionState.Naturals)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Chord Transpose",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(0.9f)
                )

                AnimatedVisibility(
                    visible = chordsToConvertList.isNotEmpty()
                ) {
                    IconRes(
                        stringPath = "drawable/remove_chords.png",
                        colorTint = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                chordsToConvertList = emptyList()
                                selectionState = SelectionState.Naturals
                            }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                AnimatedContent(
                    targetState = chordsToConvertList.isNotEmpty(),
                    transitionSpec = {
                        fadeIn() + slideInVertically(animationSpec = spring(
                            dampingRatio = 0.8f,
                            stiffness = Spring.StiffnessLow
                        ), initialOffsetY = { fullHeight -> fullHeight }) with
                                fadeOut(animationSpec = tween(200))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                        .align(Alignment.TopCenter)
                ) { hasChords ->
                    if (hasChords) {
                        ChordListToConvert {
                            chordsToConvertList
                        }
                    } else {
                        EmptyChords()
                    }
                }

                AnimatedContent(
                    targetState = selectionState,
                    transitionSpec = {
                        fadeIn() + slideInVertically(animationSpec = spring(
                            dampingRatio = 0.8f,
                            stiffness = Spring.StiffnessLow
                        ),
                            initialOffsetY = { fullHeight -> fullHeight }) with
                                fadeOut(animationSpec = tween(200))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                        .align(Alignment.BottomCenter)
                ) { state ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        when (state) {
                            is SelectionState.Composed -> {
                                ComposedChordSelector(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxSize()
                                        .align(Alignment.BottomCenter),
                                    chord = state.chord
                                ) { selected ->
                                    selectionState = SelectionState.Naturals
                                    if (selected.isNotEmpty()) {
                                        chordsToConvertList =
                                            chordsToConvertList.toMutableList()
                                                .apply { add(selected) }
                                    }
                                }
                            }

                            SelectionState.Naturals -> {
                                NaturalChordSelector(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .wrapContentHeight()
                                        .align(Alignment.BottomCenter)
                                ) { selectedChord ->
                                    selectionState = SelectionState.Composed(selectedChord)
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}

sealed class SelectionState {
    object Naturals : SelectionState()
    data class Composed(val chord: String) : SelectionState()
}
