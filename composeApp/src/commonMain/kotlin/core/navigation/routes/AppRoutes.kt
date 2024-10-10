package core.navigation.routes

import kotlinx.serialization.Serializable

sealed class AppRoutes {

    @Serializable
    data object Home : AppRoutes()

    @Serializable
    data class ProductDetails(val id: Int) : AppRoutes()

    @Serializable
    data object Cart : AppRoutes()

}