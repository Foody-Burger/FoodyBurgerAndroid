package com.foodyburger.common

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class OpResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : OpResult<T>()
    data class Error(val errorCode: String) : OpResult<Nothing>()

    companion object {
        fun success(): OpResult<Any> {
            return Success(Any())
        }
    }

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[errorCode=$errorCode]"
        }
    }
}