package com.untukwarga.id.core.api

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */
interface FeatureApi {

    fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    )

}