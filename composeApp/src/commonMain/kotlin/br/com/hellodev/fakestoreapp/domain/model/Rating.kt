package br.com.hellodev.fakestoreapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val count: Int? = null,
    val rate: Double? = null
)