package com.ajcm.chordtranspasermp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform