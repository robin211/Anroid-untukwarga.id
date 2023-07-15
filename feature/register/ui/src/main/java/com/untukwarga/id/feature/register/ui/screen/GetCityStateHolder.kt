package com.untukwarga.id.feature.register.ui.screen

import com.untukwarga.id.feature.register.domain.model.KabupatenKotaModel

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */
data class GetCityStateHolder (
    val isLoading:Boolean = false,
    val data: List<KabupatenKotaModel>? = null,
    val error:String = ""
)