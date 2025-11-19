package com.example.guia_league_of_legends.data

data class GameMode(
    val id: String,
    val name: String,
    val description: String,
    val mapImageRes: Int,
    val extraInfo: String)