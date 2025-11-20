package com.example.guia_league_of_legends.ui.objectives

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.guia_league_of_legends.data.GameMode
import com.example.guia_league_of_legends.R


val gameModes = listOf(
    GameMode(
        id = "summoners_rift",
        name = "Summoner's Rift",
        description = "El modo clásico 5v5. Objetivo: destruir el nexo enemigo controlando carriles, jungla y objetivos.",
        R.drawable.summoners_rift_map,
        extraInfo = "Campamentos iniciales:\n" +
                "Blue Buff (Sentinela Azul), Red Buff (Sentinela Rojo), Lobos, Raptors → 1:30\n" +
                "Gromp y Krugs → 1:45\n" +
                "\n" +
                "Respawn:\n" +
                "Gromp, Raptors, Lobos, Krugs → 2:15 después de ser eliminados\n" +
                "Blue y Red → 5:00 después de ser eliminados\n" +
                "\n" +
                "Objetivos menores:\n" +
                "Vacuolarvas → 3:00 en el río superior" +
                "\n" +
                "Objetivos épicos:\n" +
                "Dragón elemental → 5:00, respawn cada 5 minutos\n" +
                "Heraldo de la Grieta → 8:00\n" +
                "Barón Nashor → 20:00, reemplaza al Heraldo\n"
    ),
    GameMode(
        id = "aram",
        name = "ARAM (All Random All Mid)",
        description = "Partida 5v5 en un solo carril. Campeones aleatorios, peleas constantes y rápidas.",
        R.drawable.aram_map,
        extraInfo = "Características:\n" +
                "- No hay jungla ni campamentos neutrales\n" +
                "- Un solo carril (MID) con peleas constantes\n" +
                "- Reliquias de vida aparecen en el centro del mapa cada 90 segundos\n" +
                "- Objetivo principal: destruir el nexo enemigo"
    ),
    GameMode(
        id = "tft",
        name = "Teamfight Tactics",
        description = "Modo auto-battler. Recluta campeones, forma sinergias y compite en rondas automáticas.",
        R.drawable.tft_map,
        extraInfo = "Características:\n" +
                "- No hay jungla ni carriles tradicionales\n" +
                "- El juego se desarrolla en rondas automáticas\n" +
                "- Recluta campeones, forma sinergias y compite contra otros jugadores\n" +
                "- Objetivo: ser el último en pie con la mejor composición"
    ),
    GameMode(
        id = "urf",
        name = "URF (Ultra Rapid Fire)",
        description = "Modo Rotativo: enfriamientos reducidos, maná infinito y acción frenética.",
        R.drawable.summoners_rift_map,
        "Características:\n" +
                "- Misma jungla y carriles que Summoner’s Rift\n" +
                "- Enfriamientos reducidos y maná infinito\n" +
                "- Campamentos y objetivos épicos mantienen los mismos tiempos que en Summoner’s Rift\n" +
                "- El ritmo de juego es mucho más rápido y caótico"
    )
)
@Composable
fun GameModeDetailScreen(modeId: String) {
    val mode = gameModes.find { it.id == modeId }

    if (mode == null) {
        Text("Modo no encontrado", color = Color.Red)
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFF0F0F0F))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = mode.mapImageRes),
            contentDescription = mode.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(mode.name, style = MaterialTheme.typography.headlineMedium, color = Color(0xFFFFD700))
        Spacer(modifier = Modifier.height(8.dp))
        Text(mode.description, style = MaterialTheme.typography.bodyMedium, color = Color.White)
        Text(
            text = "Detalles estratégicos:",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFFFFD700),
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = mode.extraInfo,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier.padding(top = 10.dp)
        )

    }
}
