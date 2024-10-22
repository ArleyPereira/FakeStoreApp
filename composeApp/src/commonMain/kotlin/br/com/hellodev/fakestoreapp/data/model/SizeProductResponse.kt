package br.com.hellodev.fakestoreapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SizeProductResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)
