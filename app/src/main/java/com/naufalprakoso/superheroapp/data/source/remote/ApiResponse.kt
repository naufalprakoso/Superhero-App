package com.naufalprakoso.superheroapp.data.source.remote

import androidx.annotation.Nullable

class ApiResponse<T>(
    val status: StatusResponse,
    val body: T,
    val message: String? = ""
) {
    companion object {
        fun <T> success(@Nullable body: T): ApiResponse<T> {
            return ApiResponse(StatusResponse.SUCCESS, body, null)
        }

        fun <T> error(msg: String, @Nullable body: T): ApiResponse<T> {
            return ApiResponse(StatusResponse.ERROR, body, msg)
        }
    }
}