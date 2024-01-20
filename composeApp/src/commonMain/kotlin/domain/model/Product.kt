package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val category: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val image: String? = null,
    val price: Double? = null,
    val ratingResponse: Rating? = null,
    val title: String? = null
)