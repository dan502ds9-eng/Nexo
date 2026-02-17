package com.nexo.app.nexo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform