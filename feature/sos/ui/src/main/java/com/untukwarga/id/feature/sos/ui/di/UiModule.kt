package com.untukwarga.id.feature.sos.ui.di

import com.untukwarga.id.feature.sos.ui.navigation.SosApi
import com.untukwarga.id.feature.sos.ui.navigation.SosApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */
@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideSosApi(): SosApi {
        return SosApiImpl()
    }

}