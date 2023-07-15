package com.untukwarga.id.feature.register.data.repoImpl

import com.untukwarga.id.core.network.dataprovider.DataProvider
import com.untukwarga.id.feature.register.data.mapper.toDomainCity
import com.untukwarga.id.feature.register.data.mapper.toDomainDistrict
import com.untukwarga.id.feature.register.data.mapper.toDomainProvince
import com.untukwarga.id.feature.register.data.mapper.toDomainSubDistrict
import com.untukwarga.id.feature.register.domain.model.KabupatenKotaModel
import com.untukwarga.id.feature.register.domain.model.KecamatanModel
import com.untukwarga.id.feature.register.domain.model.KelurahanModel
import com.untukwarga.id.feature.register.domain.model.ProvinsiModel
import com.untukwarga.id.feature.register.domain.repo.RegisterRepository
import javax.inject.Inject

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */
class RegisterRepoImpl @Inject constructor(private val dataProvider: DataProvider) : RegisterRepository {
    override suspend fun getProvinsi(): List<ProvinsiModel> {
        return dataProvider.getProvince("62.json").toDomainProvince()
    }

    override suspend fun getKabupatenKota(idJson : String): List<KabupatenKotaModel> {
        return dataProvider.getRegencies(idJson).toDomainCity()
    }

    override suspend fun getKecamatan(idJson : String): List<KecamatanModel> {
        return dataProvider.getDistrict(idJson).toDomainDistrict()
    }

    override suspend fun getKelurahan(idJson: String): List<KelurahanModel> {
        return dataProvider.getSubDistrict(idJson).toDomainSubDistrict()
    }

}