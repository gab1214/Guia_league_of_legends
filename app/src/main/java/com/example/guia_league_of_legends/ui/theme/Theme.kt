package com.example.guia_league_of_legends.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    background = Color(0xFF2C2C2C),
    surface = Color(0xFFE3DEDE),
    onSurface = Color(0xFFFFD700), // dorado
    primary = Color(0xFFFFD700),
    onPrimary = Color.Black
)

@Composable
fun LeagueGuideTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}