package com.untukwarga.id.feature.login.ui.di

import com.untukwarga.id.feature.login.ui.navigation.LoginApi
import com.untukwarga.id.feature.login.ui.navigation.LoginApiImpl
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
object UiModule {

    @Provides
    fun provideLoginApi(): LoginApi {
        return LoginApiImpl()
    }

}