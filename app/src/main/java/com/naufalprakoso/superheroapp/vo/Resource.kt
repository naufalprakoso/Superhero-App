package com.naufalprakoso.superheroapp.vo

import androidx.annotation.NonNull
import androidx.annotation.Nullable

class Resource<T>(
    val status: Status,
    @param:Nullable @field:Nullable
        val data: T?,
    @param:Nullable @field:Nullable
        val message: String?
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }

        val resource = other as Resource<*>?

        if (status !== resource!!.status) {
            return false
        }
        if (if (message != null) message != resource!!.message else resource!!.message != null) {
            return false
        }
        return if (data != null) data == resource.data else resource.data == null
    }

    override fun hashCode(): Int {
        var result = status.hashCode()
        result = 31 * result + (message?.hashCode() ?: 0)
        result = 31 * result + (data?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Resource{" +
                "status=" + status +
                ", message='" + message + '\''.toString() +
                ", data=" + data +
                '}'.toString()
    }
    companion object {

        fun <T> success(@NonNull data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, @NonNull data: T): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(@NonNull data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}