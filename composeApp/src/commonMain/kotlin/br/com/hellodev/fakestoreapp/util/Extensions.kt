package br.com.hellodev.fakestoreapp.util

import androidx.compose.ui.graphics.Color

fun String?.parseColor(): Color {
    return Color(("ff" + this?.removePrefix("#")?.lowercase()).toLong(16))
}