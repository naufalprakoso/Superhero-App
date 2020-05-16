package com.naufalprakoso.superheroapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AppearanceResponse(
    @SerializedName("gender")
    val gender: String,

    @SerializedName("race")
    val race: String?,

    @SerializedName("height")
    val height: List<String>,

    @SerializedName("weight")
    val weight: List<String>,

    @SerializedName("eyeColor")
    val eyeColor: String,

    @SerializedName("hairColor")
    val hairColor: String
)