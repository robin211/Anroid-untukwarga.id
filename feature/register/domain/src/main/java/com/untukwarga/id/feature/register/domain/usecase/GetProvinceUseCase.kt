package com.untukwarga.id.feature.register.domain.usecase

import com.untukwarga.id.core.common.UiEvent
import com.untukwarga.id.feature.register.domain.repo.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */
class GetProvinceUseCase @Inject constructor(private val registerRepository: RegisterRepository) {

    operator fun invoke() = flow {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(registerRepository.getProvinsi()))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}