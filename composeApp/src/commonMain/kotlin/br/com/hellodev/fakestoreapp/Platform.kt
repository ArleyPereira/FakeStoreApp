package br.com.hellodev.fakestoreapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform