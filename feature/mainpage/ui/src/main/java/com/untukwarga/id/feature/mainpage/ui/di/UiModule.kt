package com.untukwarga.id.feature.mainpage.ui.di

import com.untukwarga.id.feature.mainpage.ui.navigation.MainPageApi
import com.untukwarga.id.feature.mainpage.ui.navigation.MainPageApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */
@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideMainPageApi(): MainPageApi {
        return MainPageApiImpl()
    }
}