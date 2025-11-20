package com.example.guia_league_of_legends.ui.champions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.guia_league_of_legends.viewmodel.ChampionViewModel

@Composable
fun ChampionDetailScreen(championId: String, viewModel: ChampionViewModel) {
    val championPair = viewModel.getChampionWithDetail(championId)

    if (championPair == null) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("No se encontró información del campeón", color = Color.Red)
        }
        return
    }

    val (champion, detail) = championPair

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 72.dp) // espacio para el menú inferior
            .padding(16.dp)
    ) {
        item {
            AsyncImage(
                model = champion.imageUrl,
                contentDescription = champion.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }

        item { Spacer(modifier = Modifier.height(12.dp)) }

        item {
            Text(champion.name, style = MaterialTheme.typography.headlineMedium, color = Color(0xFFFFD700))
            Text(champion.description, style = MaterialTheme.typography.bodyMedium, color = Color.White)
            Text(detail.blurb, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text("Atributos", style = MaterialTheme.typography.titleMedium, color = Color(0xFFFFD700))
            Text("Ataque: ${detail.info.attack}", color = Color.White)
            Text("Defensa: ${detail.info.defense}", color = Color.White)
            Text("Magia: ${detail.info.magic}", color = Color.White)
            Text("Dificultad: ${detail.info.difficulty}", color = Color.White)
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text("Estadísticas", style = MaterialTheme.typography.titleMedium, color = Color(0xFFFFD700))
            Text("HP: ${detail.stats.hp} (+${detail.stats.hpperlevel} por nivel)", color = Color.White)
            Text("MP: ${detail.stats.mp} (+${detail.stats.mpperlevel} por nivel)", color = Color.White)
            Text("Armadura: ${detail.stats.armor} (+${detail.stats.armorperlevel} por nivel)", color = Color.White)
            Text("Resistencia mágica: ${detail.stats.spellblock} (+${detail.stats.spellblockperlevel} por nivel)", color = Color.White)
            Text("Rango de ataque: ${detail.stats.attackrange}", color = Color.White)
            Text("Velocidad de ataque: ${detail.stats.attackspeed} (+${detail.stats.attackspeedperlevel}% por nivel)", color = Color.White)
            Text("Velocidad de movimiento: ${detail.stats.movespeed}", color = Color.White)
            Text("Regeneración de HP: ${detail.stats.hpregen} (+${detail.stats.hpregenperlevel} por nivel)", color = Color.White)
            Text("Regeneración de MP: ${detail.stats.mpregen} (+${detail.stats.mpregenperlevel} por nivel)", color = Color.White)
            Text("Daño crítico: ${detail.stats.crit} (+${detail.stats.critperlevel} por nivel)", color = Color.White)
            Text("Daño de ataque: ${detail.stats.attackdamage} (+${detail.stats.attackdamageperlevel} por nivel)", color = Color.White)
        }
    }
}

