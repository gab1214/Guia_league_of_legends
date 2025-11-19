package com.example.guia_league_of_legends.ui.navigation

import androidx.annotation.DrawableRes
import com.example.guia_league_of_legends.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavItem("home", "Inicio", R.drawable.ic_home)
    object Champions : BottomNavItem("champions", "Campeones", R.drawable.ic_champions)
    object Objectives : BottomNavItem("Modos", "Modos", R.drawable.ic_modos)
    object Profile : BottomNavItem("profile", "Perfil", R.drawable.ic_profile)
}