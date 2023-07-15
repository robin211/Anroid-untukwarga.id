package com.untukwarga.id.feature.register.data.mapper

import com.untukwarga.id.core.network.model.location.CityRegencyDTO
import com.untukwarga.id.core.network.model.location.DistrictDTO
import com.untukwarga.id.core.network.model.location.ProvinceDTO
import com.untukwarga.id.core.network.model.location.SubDistrictDTO
import com.untukwarga.id.feature.register.domain.model.KabupatenKotaModel
import com.untukwarga.id.feature.register.domain.model.KecamatanModel
import com.untukwarga.id.feature.register.domain.model.KelurahanModel
import com.untukwarga.id.feature.register.domain.model.ProvinsiModel

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */

fun List<ProvinceDTO>.toDomainProvince() : List<ProvinsiModel> {
    return this.map {
        ProvinsiModel(it.id, it.name)
    }
}

fun List<CityRegencyDTO>.toDomainCity() : List<KabupatenKotaModel> {
    return this.map {
        KabupatenKotaModel(it.id, it.name)
    }
}

fun List<DistrictDTO>.toDomainDistrict() : List<KecamatanModel> {
    return this.map {
        KecamatanModel(it.id, it.name)
    }
}

fun List<SubDistrictDTO>.toDomainSubDistrict() : List<KelurahanModel> {
    return this.map {
        KelurahanModel(it.id, it.name)
    }
}

fun List<ProvinsiModel>.toProvinsiListString() : List<String>{
    return this.map {
        it.name
    }
}

fun List<KabupatenKotaModel>.toKabupatenListString() : List<String>{
    return this.map {
        it.name
    }
}

fun List<KecamatanModel>.toKecamatanListString() : List<String>{
    return this.map {
        it.name
    }
}