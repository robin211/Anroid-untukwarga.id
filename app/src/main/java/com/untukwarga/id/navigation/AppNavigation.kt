package com.untukwarga.id.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.untukwarga.id.core.common.NavigationConstant

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */

@Composable
fun AppNavGraph(navHostController: NavHostController, navigationProvider: NavigationProvider){
    NavHost(navController = navHostController, startDestination = NavigationConstant.mainPageNestedRoute ){
        navigationProvider.loginApi.registerGraph(
            navHostController, this
        )

        navigationProvider.registerApi.registerGraph(
            navHostController, this
        )

        navigationProvider.mainPageApi.registerGraph(
            navHostController, this
        )

        navigationProvider.sosApi.registerGraph(
            navHostController, this
        )

    }
}