package com.ajcm.chordtranspasermp.transpaser

object ChordConverter {
    private val chordRegex = Regex("^([A-G])(#|b|)(.*)?(7)?$")

    fun transform(chords: List<String>, semiTone: Int): List<String> {
        return chords.map { chord ->
            transform(chord, semiTone)
        }
    }

    fun transform(chord: String, semiTone: Int): String {
        val adjustment = semiTone.rem(12)
        return chordRegex.find(chord)?.destructured?.let { (root, type, complement, seventh) ->
            val originalChords = if (type == "b") Chord.listWithFlats else Chord.listWithMajoirs
            originalChords.indexOf("$root$type").takeIf { it != -1 }?.let {
                val newRoot = originalChords[(it + adjustment + 12) % 12]
                "$newRoot$complement$seventh"
            } ?: chord
        } ?: chord
    }
}
