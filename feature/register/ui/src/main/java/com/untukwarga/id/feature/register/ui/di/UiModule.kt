package com.untukwarga.id.feature.register.ui.di

import com.untukwarga.id.feature.register.ui.navigation.RegisterApi
import com.untukwarga.id.feature.register.ui.navigation.RegisterApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */
@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideRegisterApi(): RegisterApi {
        return RegisterApiImpl()
    }

}