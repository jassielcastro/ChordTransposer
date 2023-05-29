package com.ajcm.chordtranspasermp.transpaser

object Chord {

    val compositions: Map<String, List<String>>
        get() {
            return mapOf(
                "C" to listOf("", "#", "m", "#m", "sus", "sus2", "sus4", "sus7", "5", "7", "m7", "maj7", "dim", "dim7"),
                "D" to listOf("", "#", "b", "m", "#m", "sus", "sus2", "sus4", "sus7", "5", "7", "m7", "maj7", "dim", "dim7"),
                "E" to listOf("", "m", "sus", "sus2", "sus4", "sus7", "5", "7", "m7", "maj7", "dim", "dim7"),
                "F" to listOf("", "#", "m", "#m", "sus", "sus2", "sus4", "sus7", "5", "7", "m7", "maj7", "dim", "dim7"),
                "G" to listOf("", "#", "b", "m", "#m", "sus", "sus2", "sus4", "sus7", "5", "7", "m7", "maj7", "dim", "dim7"),
                "A" to listOf("", "#", "m", "#m", "sus", "sus2", "sus4", "sus7", "5", "7", "m7", "maj7", "dim", "dim7"),
                "B" to listOf("", "b", "m", "sus", "sus2", "sus4", "sus7", "5", "7", "m7", "maj7", "dim", "dim7"),
            )
        }

    internal val listWithMajoirs: List<String> = listOf(
        "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
    )

    internal val listWithFlats: List<String> = listOf(
        "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"
    )
}
