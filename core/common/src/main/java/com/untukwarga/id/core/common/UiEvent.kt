package com.untukwarga.id.core.common

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */
sealed class UiEvent<T>(val data:T?=null, val message:String?=null){
    class Loading<T>():UiEvent<T>()

    class Success<T>(data:T):UiEvent<T>(data = data)

    class Error<T>(message:String):UiEvent<T>(message = message)
}