package com.example.guia_league_of_legends.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.guia_league_of_legends.data.Champion
import com.example.guia_league_of_legends.data.LaneRole
import com.example.guia_league_of_legends.R

@Composable
fun ChampionCard(champion: Champion, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF231F1F))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = champion.imageUrl,
                contentDescription = champion.name,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 12.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    val iconRes = when (champion.laneRoles.firstOrNull()) {
                        LaneRole.TOP -> R.drawable.ic_top
                        LaneRole.JUNGLA -> R.drawable.ic_jungla
                        LaneRole.MID -> R.drawable.ic_mid
                        LaneRole.ADC -> R.drawable.ic_adc
                        LaneRole.SOPORTE -> R.drawable.ic_soporte
                        else -> null
                    }

                    if (iconRes != null) {
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = null,
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                    Text(
                        text = champion.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFFFD700)
                    )
                }

                Text(
                    text = champion.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row {
                    champion.laneRoles.forEach { role ->
                        AssistChip(
                            onClick = {},
                            label = { Text(role.name, color = Color.Black) },
                            colors = AssistChipDefaults.assistChipColors(containerColor = Color(0xFFFFD700)),
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }
                }
            }
        }
    }
}