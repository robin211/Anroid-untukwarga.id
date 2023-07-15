package com.untukwarga.id.feature.register.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.untukwarga.id.core.api.FeatureApi

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */

interface RegisterApi : FeatureApi{}

class RegisterApiImpl : RegisterApi {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        IntenalRegisterFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }

}