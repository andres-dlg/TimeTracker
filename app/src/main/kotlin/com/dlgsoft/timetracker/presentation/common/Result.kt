package com.dlgsoft.timetracker.presentation.common

sealed class Result<out T>(
    val data: T? = null,
    val error: Throwable? = null,
    val isLoading: Boolean = false
) {
  class Success<T>(data: T?): Result<T?>(data)

  class Loading<T>(isLoading: Boolean, data: T? = null):
      Result<T>(data, isLoading = isLoading)

  class Error<T>(error: Throwable? = null, data: T? = null):
      Result<T>(data, error = error)
}