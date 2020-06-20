package com.naufalprakoso.superheroapp.network.response

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("xs")
    val xs: String,

    @SerializedName("sm")
    val sm: String,

    @SerializedName("md")
    val md: String,

    @SerializedName("lg")
    val lg: String
)