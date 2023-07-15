package com.untukwarga.id.di

import com.untukwarga.id.feature.login.ui.navigation.LoginApi
import com.untukwarga.id.feature.mainpage.ui.navigation.MainPageApi
import com.untukwarga.id.feature.register.ui.navigation.RegisterApi
import com.untukwarga.id.feature.sos.ui.navigation.SosApi
import com.untukwarga.id.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigatinProvider(
        loginApi: LoginApi,
        registerApi: RegisterApi,
        mainPageApi: MainPageApi,
        sosApi: SosApi
    ): NavigationProvider {
        return NavigationProvider(
            loginApi,
            registerApi,
            mainPageApi,
            sosApi
        )
    }

}