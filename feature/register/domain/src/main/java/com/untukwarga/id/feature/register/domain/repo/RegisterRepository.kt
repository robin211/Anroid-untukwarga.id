package com.untukwarga.id.feature.register.domain.repo

import com.untukwarga.id.feature.register.domain.model.KabupatenKotaModel
import com.untukwarga.id.feature.register.domain.model.KecamatanModel
import com.untukwarga.id.feature.register.domain.model.KelurahanModel
import com.untukwarga.id.feature.register.domain.model.ProvinsiModel

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */
interface RegisterRepository {

    suspend fun getProvinsi() : List<ProvinsiModel>

    suspend fun getKabupatenKota(idJson : String) : List<KabupatenKotaModel>

    suspend fun getKecamatan(idJson : String) : List<KecamatanModel>

    suspend fun getKelurahan(idJson : String) : List<KelurahanModel>

}