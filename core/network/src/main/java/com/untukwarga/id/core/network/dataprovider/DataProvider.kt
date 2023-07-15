package com.untukwarga.id.core.network.dataprovider

import com.untukwarga.id.core.network.ApiService
import javax.inject.Inject

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */
class DataProvider @Inject constructor(private val apiService: ApiService) {

    suspend fun getProvince(idJson: String) = apiService.getProvinces(idJson)

    suspend fun getRegencies(idJson: String) = apiService.getRegencies(idJson)

    suspend fun getDistrict(idJson: String) = apiService.getDistricts(idJson)

    suspend fun getSubDistrict(idJson: String) = apiService.getSubDistricts(idJson)
}