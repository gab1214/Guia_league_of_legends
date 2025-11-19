package com.example.guia_league_of_legends.data

data class ChampionDetail(
    val id: String,
    val title: String,
    val blurb: String,
    val info: ChampionInfo,
    val tags: List<String>,
    val stats: ChampionStats
)

data class ChampionInfo(
    val attack: Int,
    val defense: Int,
    val magic: Int,
    val difficulty: Int
)

data class ChampionStats(
    val hp: Double,
    val hpperlevel: Double,
    val mp: Double,
    val mpperlevel: Double,
    val movespeed: Double,
    val armor: Double,
    val armorperlevel: Double,
    val spellblock: Double,
    val spellblockperlevel: Double,
    val attackrange: Double,
    val hpregen: Double,
    val hpregenperlevel: Double,
    val mpregen: Double,
    val mpregenperlevel: Double,
    val crit: Double,
    val critperlevel: Double,
    val attackdamage: Double,
    val attackdamageperlevel: Double,
    val attackspeed: Double,
    val attackspeedperlevel: Double
)