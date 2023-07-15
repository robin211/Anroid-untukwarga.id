package com.untukwarga.id.feature.register.ui.screen

import com.untukwarga.id.feature.register.domain.model.KecamatanModel

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */
data class GetDistrictStateHolder (
    val isLoading:Boolean = false,
    val data: List<KecamatanModel>? = null,
    val error:String = ""
)