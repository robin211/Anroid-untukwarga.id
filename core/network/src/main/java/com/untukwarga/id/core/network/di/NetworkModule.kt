package com.untukwarga.id.core.network.di

import com.untukwarga.id.core.network.ApiService
import com.untukwarga.id.core.network.dataprovider.DataProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */
@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideAPIService(): ApiService{
        return Retrofit.Builder().baseUrl("https://dev-untukwarga-location.nos.wjv-1.neo.id/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideDataProvider(apiService: ApiService): DataProvider {
        return DataProvider(apiService)
    }

}