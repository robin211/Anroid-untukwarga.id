package com.untukwarga.id.core.network

import com.untukwarga.id.core.network.model.location.CityRegencyDTO
import com.untukwarga.id.core.network.model.location.DistrictDTO
import com.untukwarga.id.core.network.model.location.ProvinceDTO
import com.untukwarga.id.core.network.model.location.SubDistrictDTO
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */
interface ApiService {

    @GET("indonesia/provinces/{idJson}")
    suspend fun getProvinces(
        @Path("idJson") idJson : String
    ): List<ProvinceDTO>

    @GET("indonesia/regencies/{idJson}")
    suspend fun getRegencies(
        @Path("idJson") idJson : String
    ): List<CityRegencyDTO>

    @GET("indonesia/districts/{idJson}")
    suspend fun getDistricts(
        @Path("idJson") idJson : String
    ): List<DistrictDTO>

    @GET("indonesia/villages/{idJson}")
    suspend fun getSubDistricts(
        @Path("idJson") idJson : String
    ): List<SubDistrictDTO>

}