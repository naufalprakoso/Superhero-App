package com.naufalprakoso.superheroapp.network.response

import com.google.gson.annotations.SerializedName

data class ConnectionResponse(
    @SerializedName("groupAffiliation")
    val groupAffiliation: String,

    @SerializedName("relatives")
    val relatives: String
)