package com.naufalprakoso.superheroapp.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.naufalprakoso.superheroapp.data.source.local.entity.Hero
import com.naufalprakoso.superheroapp.data.source.local.entity.PowerStat
import com.naufalprakoso.superheroapp.data.source.local.entity.Work
import com.naufalprakoso.superheroapp.data.source.local.entity.Image
import com.naufalprakoso.superheroapp.data.source.local.entity.Connection
import com.naufalprakoso.superheroapp.data.source.local.entity.Appearance
import com.naufalprakoso.superheroapp.data.source.local.entity.Biography

data class Superhero(
    @Embedded
    val hero: Hero,

    @Relation(parentColumn = "id", entityColumn = "id", entity = PowerStat::class)
    val powerStat: PowerStat,

    @Relation(parentColumn = "id", entityColumn = "id", entity = Work::class)
    val work: Work,

    @Relation(parentColumn = "id", entityColumn = "id", entity = Biography::class)
    val biography: Biography,

    @Relation(parentColumn = "id", entityColumn = "id", entity = Appearance::class)
    val appearance: Appearance,

    @Relation(parentColumn = "id", entityColumn = "id", entity = Connection::class)
    val connection: Connection,

    @Relation(parentColumn = "id", entityColumn = "id", entity = Image::class)
    val image: Image
)