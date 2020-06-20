package com.naufalprakoso.superheroapp.network.response

import com.google.gson.annotations.SerializedName

data class WorkResponse(
    @SerializedName("occupation")
    val occupation: String,

    @SerializedName("base")
    val base: String
)