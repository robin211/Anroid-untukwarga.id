package com.untukwarga.id.navigation

import com.untukwarga.id.feature.login.ui.navigation.LoginApi
import com.untukwarga.id.feature.mainpage.ui.navigation.MainPageApi
import com.untukwarga.id.feature.register.ui.navigation.RegisterApi
import com.untukwarga.id.feature.sos.ui.navigation.SosApi

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */
data class NavigationProvider(
    val loginApi: LoginApi,
    val registerApi: RegisterApi,
    val mainPageApi: MainPageApi,
    val sosApi: SosApi
)