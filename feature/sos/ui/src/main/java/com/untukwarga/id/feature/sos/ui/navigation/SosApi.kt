package com.untukwarga.id.feature.sos.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.untukwarga.id.core.api.FeatureApi

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */

interface SosApi : FeatureApi{}

class SosApiImpl : SosApi {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalSosFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }
}