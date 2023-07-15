package com.untukwarga.id.feature.register.data.di

import com.untukwarga.id.core.network.dataprovider.DataProvider
import com.untukwarga.id.feature.register.data.repoImpl.RegisterRepoImpl
import com.untukwarga.id.feature.register.domain.repo.RegisterRepository
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
object DataLayerModule {

    @Provides
    fun provideRegisterRepo(dataProvider: DataProvider):RegisterRepository{
        return RegisterRepoImpl(dataProvider)
    }

}