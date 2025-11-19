package com.example.guia_league_of_legends.data


enum class LaneRole {
    TOP,
    JUNGLA,
    MID,
    ADC,
    SOPORTE
}

data class Champion(
    val id: String,
    val name: String,
    val role: String,
    val description: String,
    val imageUrl: String,
    val laneRoles: List<LaneRole>
)
