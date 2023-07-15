package com.untukwarga.id.feature.mainpage.ui.screen

import com.untukwarga.id.core.common.NavigationConstant
import com.untukwarga.id.feature.mainpage.ui.R

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */
sealed class MainPage(
    val route: String?,
    val title: String?,
    val iconId: Int?
) {
    object Serambi : MainPage(
        route = NavigationConstant.serambiScreenRoute,
        title = "Serambi",
        iconId = R.drawable.serambi
    )
    object Selasar : MainPage(
        route = NavigationConstant.selasarScreenRoute,
        title = "Selasar",
        iconId = R.drawable.selasar
    )
    object Blank : MainPage(
        route = null,
        title = "",
        iconId = null
    )
    object Pustaka : MainPage(
        route = NavigationConstant.pustakaScreenRoute,
        title = "Pustaka",
        iconId = R.drawable.pustaka
    )
    object Daku : MainPage(
        route = NavigationConstant.dakuScreenRoute,
        title = "Daku",
        iconId = R.drawable.daku
    )
}