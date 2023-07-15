package com.untukwarga.id.feature.login.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.untukwarga.id.core.api.FeatureApi
import com.untukwarga.id.core.common.NavigationConstant
import com.untukwarga.id.feature.login.ui.screen.LoginScreen

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */
internal object InternalLoginFeatureApi : FeatureApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = NavigationConstant.loginScreenRoute,
            route = NavigationConstant.loginNestedRoute
        ){
            composable(NavigationConstant.loginScreenRoute){
//                val viewModel = hiltViewModel<LoginViewModel>()
//                LoginTestScreen(viewModel = viewModel, navHostController = navController)
                LoginScreen(navController)
            }
        }
    }
}