package br.com.hellodev.fakestoreapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("category")
    val category: String?,

    @SerialName("description")
    val description: String?,

    @SerialName("id")
    val id: Int?,

    @SerialName("image")
    val image: String?,

    @SerialName("price")
    val price: Double?,

    @SerialName("rating")
    val ratingResponse: RatingResponse?,

    @SerialName("title")
    val title: String?,

    @SerialName("colors")
    val colors: List<ProductColorResponse>? = null
)