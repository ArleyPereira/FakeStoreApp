package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SizeProduct(
    val id: Int? = null,
    val name: String? = null
) {
    companion object {
        fun getSizeOptions() = listOf(
            SizeProduct(id = 1, name = "39 BR"),
            SizeProduct(id = 2, name = "40 BR"),
            SizeProduct(id = 3, name = "41 BR"),
            SizeProduct(id = 4, name = "42 BR"),
            SizeProduct(id = 5, name = "43 BR"),
            SizeProduct(id = 6, name = "44 BR"),
            SizeProduct(id = 7, name = "45 BR"),
            SizeProduct(id = 8, name = "46 BR"),
            SizeProduct(id = 9, name = "47 BR"),
            SizeProduct(id = 10, name = "48 BR"),
            SizeProduct(id = 11, name = "49 BR")
        )
    }
}
