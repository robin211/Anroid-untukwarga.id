package com.untukwarga.id.feature.register.domain.di

import com.untukwarga.id.feature.register.domain.repo.RegisterRepository
import com.untukwarga.id.feature.register.domain.usecase.GetCityUseCase
import com.untukwarga.id.feature.register.domain.usecase.GetDistrictUseCase
import com.untukwarga.id.feature.register.domain.usecase.GetProvinceUseCase
import com.untukwarga.id.feature.register.domain.usecase.GetSubDistrictUseCase
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
object DomainLayerModule {

    @Provides
    fun provideGetProvinceUseCase(registerRepository: RegisterRepository): GetProvinceUseCase{
        return GetProvinceUseCase(registerRepository)
    }

    @Provides
    fun provideGetCityUseCase(registerRepository: RegisterRepository): GetCityUseCase{
        return GetCityUseCase(registerRepository)
    }

    @Provides
    fun provideGetDistrictUseCase(registerRepository: RegisterRepository): GetDistrictUseCase{
        return GetDistrictUseCase(registerRepository)
    }

    @Provides
    fun provideGetSubDistrictUseCase(registerRepository: RegisterRepository): GetSubDistrictUseCase{
        return GetSubDistrictUseCase(registerRepository)
    }

}