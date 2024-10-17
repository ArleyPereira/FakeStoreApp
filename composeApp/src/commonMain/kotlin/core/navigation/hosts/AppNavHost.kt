package core.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import core.navigation.routes.AppRoutes
import presenter.features.cart.screen.CartScreen
import presenter.features.details.screen.ProductDetailsScreen
import presenter.features.products.screen.ProductsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = AppRoutes.Home
    ) {
        composable<AppRoutes.Home> {
            ProductsScreen(
                navigateToProductDetails = { id ->
                    navHostController.navigate(AppRoutes.ProductDetails(id))
                },
                navigateToCart = {
                    navHostController.navigate(AppRoutes.Cart)
                }
            )
        }

        composable<AppRoutes.ProductDetails> {
            ProductDetailsScreen(
                navigateToCartScreen = {
                    navHostController.navigate(AppRoutes.Cart)
                },
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }

        composable<AppRoutes.Cart> {
            CartScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}