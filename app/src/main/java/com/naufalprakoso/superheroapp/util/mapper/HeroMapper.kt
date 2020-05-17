package com.naufalprakoso.superheroapp.util.mapper

import com.naufalprakoso.superheroapp.data.source.local.entity.Appearance
import com.naufalprakoso.superheroapp.data.source.local.entity.Image
import com.naufalprakoso.superheroapp.data.source.local.entity.Work
import com.naufalprakoso.superheroapp.data.source.local.entity.Connection
import com.naufalprakoso.superheroapp.data.source.local.entity.Hero
import com.naufalprakoso.superheroapp.data.source.local.entity.Biography
import com.naufalprakoso.superheroapp.data.source.local.entity.PowerStat
import com.naufalprakoso.superheroapp.data.source.remote.response.HeroResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.PowerStatResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.WorkResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.ConnectionResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.BiographyResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.AppearanceResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.ImageResponse

class HeroMapper {
    fun convertToSuperheroEntity(heroesResponse: HeroResponse): Hero {
        return Hero(
            heroesResponse.id,
            heroesResponse.name,
            heroesResponse.slug,
            heroesResponse.biography.alignment
        )
    }

    fun convertResponseToPowerStat(powerStatResponse: PowerStatResponse, id: Long): PowerStat {
        return PowerStat(
            id,
            powerStatResponse.intelligence,
            powerStatResponse.strength,
            powerStatResponse.speed,
            powerStatResponse.durability,
            powerStatResponse.power,
            powerStatResponse.combat
        )
    }

    fun convertResponseToWork(workResponse: WorkResponse, id: Long): Work {
        return Work(
            id,
            workResponse.occupation,
            workResponse.base
        )
    }

    fun convertResponseToAppearance(appearanceResponse: AppearanceResponse, id: Long): Appearance {
        return Appearance(
            id,
            appearanceResponse.gender,
            appearanceResponse.race,
            appearanceResponse.height.joinToString(","),
            appearanceResponse.weight.joinToString(","),
            appearanceResponse.eyeColor,
            appearanceResponse.hairColor
        )
    }
    
    fun convertResponseToBiography(biographyResponse: BiographyResponse, id: Long): Biography {
        return Biography(
            id,
            biographyResponse.fullName,
            biographyResponse.alterEgos,
            biographyResponse.aliases.joinToString(","),
            biographyResponse.placeOfBirth,
            biographyResponse.firstAppearance,
            biographyResponse.publisher,
            biographyResponse.alignment
        )
    }
    
    fun convertResponseToConnection(connectionResponse: ConnectionResponse, id: Long): Connection {
        return Connection(
            id,
            connectionResponse.groupAffiliation,
            connectionResponse.relatives
        )
    }
    
    fun convertResponseToImage(imageResponse: ImageResponse, id: Long): Image {
        return Image(
            id,
            imageResponse.xs,
            imageResponse.sm,
            imageResponse.md,
            imageResponse.lg
        )
    }
}