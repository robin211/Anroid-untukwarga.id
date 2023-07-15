package com.untukwarga.id.feature.register.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.untukwarga.id.core.api.FeatureApi
import com.untukwarga.id.core.common.NavigationConstant
import com.untukwarga.id.core.common.TestPage
import com.untukwarga.id.feature.register.ui.screen.RegisterScreen
import com.untukwarga.id.feature.register.ui.screen.RegisterViewModel

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */
object IntenalRegisterFeatureApi : FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = NavigationConstant.registerScreenRoute,
            route = NavigationConstant.registerNestedRoute
        ){
            composable(NavigationConstant.registerScreenRoute){
                val viewModel = hiltViewModel<RegisterViewModel>()
//                LoginTestScreen(viewModel = viewModel, navHostController = navController)
                RegisterScreen(viewModel, navController)
            }
        }
    }
}