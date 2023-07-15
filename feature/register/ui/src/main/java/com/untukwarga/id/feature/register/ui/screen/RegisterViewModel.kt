package com.untukwarga.id.feature.register.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.untukwarga.id.core.common.UiEvent
import com.untukwarga.id.feature.register.domain.model.ProvinsiModel
import com.untukwarga.id.feature.register.domain.usecase.GetCityUseCase
import com.untukwarga.id.feature.register.domain.usecase.GetDistrictUseCase
import com.untukwarga.id.feature.register.domain.usecase.GetProvinceUseCase
import com.untukwarga.id.feature.register.domain.usecase.GetSubDistrictUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */

@HiltViewModel
class RegisterViewModel
@Inject constructor(
    private val getProvinceUseCase: GetProvinceUseCase,
    private val getCityUseCase: GetCityUseCase,
    private val getDistrictUseCase: GetDistrictUseCase,
    private val getSubDistrictUseCase: GetSubDistrictUseCase
) : ViewModel() {

    private val _provinceModel = mutableStateOf(GetProvinceStateHolder())
    val provinceModel: State<GetProvinceStateHolder> get() = _provinceModel

    private val _cityModel = mutableStateOf(GetCityStateHolder())
    val cityModel: State<GetCityStateHolder> get() = _cityModel

    private val _districtModel = mutableStateOf(GetDistrictStateHolder())
    val districtModel: State<GetDistrictStateHolder> get() = _districtModel

    private val _subDistrictModel = mutableStateOf(GetSubDistrictStateHolder())
    val subDistrictModel: State<GetSubDistrictStateHolder> get() = _subDistrictModel

    init {
        getProvince()
    }


    fun getProvinceList(){
        getProvince()
    }

    fun getCityList(idJson : String){
        getCity(idJson)
    }

    fun getDistrictList(idJson: String){
        getDistrict(idJson)
    }

    fun getSubDistrictList(idJson: String){
        getSubDistrict(idJson)
    }


    private fun getProvince() = viewModelScope.launch {
        getProvinceUseCase().onEach {
            when (it){
                is UiEvent.Loading->{
                    _provinceModel.value = GetProvinceStateHolder(isLoading = true)
                }
                is UiEvent.Error->{
                    _provinceModel.value = GetProvinceStateHolder(error = it.message.toString())
                }
                is UiEvent.Success->{
                    _provinceModel.value = GetProvinceStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCity(idJson : String) = viewModelScope.launch {
        getCityUseCase(idJson).onEach {
            when (it){
                is UiEvent.Loading->{
                    _cityModel.value = GetCityStateHolder(isLoading = true)
                }
                is UiEvent.Error->{
                    _cityModel.value = GetCityStateHolder(error = it.message.toString())
                }
                is UiEvent.Success->{
                    _cityModel.value = GetCityStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getDistrict(idJson : String) = viewModelScope.launch {
        getDistrictUseCase(idJson).onEach {
            when (it){
                is UiEvent.Loading->{
                    _districtModel.value = GetDistrictStateHolder(isLoading = true)
                }
                is UiEvent.Error->{
                    _districtModel.value = GetDistrictStateHolder(error = it.message.toString())
                }
                is UiEvent.Success->{
                    _districtModel.value = GetDistrictStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getSubDistrict(idJson : String) = viewModelScope.launch {
        getSubDistrictUseCase(idJson).onEach {
            when (it){
                is UiEvent.Loading->{
                    _subDistrictModel.value = GetSubDistrictStateHolder(isLoading = true)
                }
                is UiEvent.Error->{
                    _subDistrictModel.value = GetSubDistrictStateHolder(error = it.message.toString())
                }
                is UiEvent.Success->{
                    _subDistrictModel.value = GetSubDistrictStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}