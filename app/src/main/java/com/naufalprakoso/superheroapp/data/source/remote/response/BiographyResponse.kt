package com.naufalprakoso.superheroapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class BiographyResponse(
    @SerializedName("fullName")
    val fullName: String,

    @SerializedName("alterEgos")
    val alterEgos: String,

    @SerializedName("aliases")
    val aliases: List<String>,

    @SerializedName("placeOfBirth")
    val placeOfBirth: String,

    @SerializedName("firstAppearance")
    val firstAppearance: String,

    @SerializedName("publisher")
    val publisher: String?,

    @SerializedName("alignment")
    val alignment: String

)