package br.com.hellodev.fakestoreapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductColor(
    @SerialName("id")
    val id: Int?,
    @SerialName("color")
    val color: String?
)