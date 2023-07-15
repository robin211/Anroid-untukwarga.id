package com.untukwarga.id.feature.register.ui.screen

import com.untukwarga.id.feature.register.domain.model.KelurahanModel

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */
data class GetSubDistrictStateHolder (
    val isLoading:Boolean = false,
    val data: List<KelurahanModel>? = null,
    val error:String = ""
)