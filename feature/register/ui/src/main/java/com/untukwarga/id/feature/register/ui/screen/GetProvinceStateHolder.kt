package com.untukwarga.id.feature.register.ui.screen

import com.untukwarga.id.feature.register.domain.model.ProvinsiModel

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */
data class GetProvinceStateHolder (
    val isLoading:Boolean = false,
    val data: List<ProvinsiModel>? = null,
    val error:String = ""
)