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
    val unselectedIconId: Int?,
    val selectedIconId: Int?
) {
    object Serambi : MainPage(
        route = NavigationConstant.serambiScreenRoute,
        title = "Serambi",
        unselectedIconId = R.drawable.serambi,
        selectedIconId = R.drawable.serambifilled
    )
    object Selasar : MainPage(
        route = NavigationConstant.selasarScreenRoute,
        title = "Selasar",
        unselectedIconId = R.drawable.selasar,
        selectedIconId = R.drawable.selasar
    )
    object Blank : MainPage(
        route = null,
        title = "",
        unselectedIconId = null,
        selectedIconId = null
    )
    object Pustaka : MainPage(
        route = NavigationConstant.pustakaScreenRoute,
        title = "Pustaka",
        unselectedIconId = R.drawable.pustaka,
        selectedIconId = R.drawable.pustaka
    )
    object Daku : MainPage(
        route = NavigationConstant.dakuScreenRoute,
        title = "Daku",
        unselectedIconId = R.drawable.daku,
        selectedIconId = R.drawable.dakufilled
    )
}