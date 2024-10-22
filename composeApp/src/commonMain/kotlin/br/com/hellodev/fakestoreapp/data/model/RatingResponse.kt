package br.com.hellodev.fakestoreapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingResponse(
    @SerialName("count")
    val count: Int?,
    @SerialName("rate")
    val rate: Double?
)