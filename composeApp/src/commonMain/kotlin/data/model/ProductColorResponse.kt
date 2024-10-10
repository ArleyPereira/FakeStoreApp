package data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductColorResponse(
    @SerialName("id")
    val id: Int?,
    @SerialName("color")
    val color: String?
)