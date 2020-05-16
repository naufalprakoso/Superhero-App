package com.naufalprakoso.superheroapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class WorkResponse(
    @SerializedName("occupation")
    val occupation: String,

    @SerializedName("base")
    val base: String
)