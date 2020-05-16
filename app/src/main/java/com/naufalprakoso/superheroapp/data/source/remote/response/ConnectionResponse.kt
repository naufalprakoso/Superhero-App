package com.naufalprakoso.superheroapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ConnectionResponse(
    @SerializedName("groupAffiliation")
    val groupAffiliation: String,

    @SerializedName("relatives")
    val relatives: String
)