package com.untukwarga.id.feature.login.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.untukwarga.id.core.api.FeatureApi

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */
interface LoginApi : FeatureApi {}

class LoginApiImpl : LoginApi {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalLoginFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }
}