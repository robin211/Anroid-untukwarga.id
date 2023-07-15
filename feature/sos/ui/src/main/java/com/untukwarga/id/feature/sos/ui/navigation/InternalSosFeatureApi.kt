package com.untukwarga.id.feature.sos.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.untukwarga.id.core.api.FeatureApi
import com.untukwarga.id.core.common.NavigationConstant
import com.untukwarga.id.core.common.TestPage
import com.untukwarga.id.feature.sos.ui.screen.SosScreen

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */
object InternalSosFeatureApi : FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = NavigationConstant.sosPageScreenRoute,
            route = NavigationConstant.sosPageNestedRoute
        ){
            composable(NavigationConstant.sosPageScreenRoute){
//                val viewModel = hiltViewModel<LoginViewModel>()
//                LoginTestScreen(viewModel = viewModel, navHostController = navController)
                SosScreen(navController)
            }
        }
    }
}