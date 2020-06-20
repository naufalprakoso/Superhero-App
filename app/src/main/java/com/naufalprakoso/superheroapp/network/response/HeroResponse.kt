package com.naufalprakoso.superheroapp.network.response

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("powerstats")
    val powerStat: PowerStatResponse,

    @SerializedName("appearance")
    val appearance: AppearanceResponse,

    @SerializedName("biography")
    val biography: BiographyResponse,

    @SerializedName("work")
    val work: WorkResponse,

    @SerializedName("connections")
    val connection: ConnectionResponse,

    @SerializedName("images")
    val image: ImageResponse
)