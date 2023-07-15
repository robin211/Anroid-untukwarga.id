package com.untukwarga.id.feature.mainpage.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.untukwarga.id.core.api.FeatureApi

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */

interface MainPageApi : FeatureApi {

}

class MainPageApiImpl : MainPageApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalMainPageFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }

}