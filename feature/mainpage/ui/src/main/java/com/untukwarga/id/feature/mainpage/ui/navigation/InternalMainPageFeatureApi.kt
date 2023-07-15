package com.untukwarga.id.feature.mainpage.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.untukwarga.id.core.api.FeatureApi
import com.untukwarga.id.core.common.NavigationConstant
import com.untukwarga.id.feature.mainpage.ui.screen.MainPageScreen

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */
object InternalMainPageFeatureApi : FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            startDestination = NavigationConstant.mainPageScreenRoute,
            route = NavigationConstant.mainPageNestedRoute
        ){
            composable(NavigationConstant.mainPageScreenRoute){
                MainPageScreen(navController)
            }
        }
    }
}