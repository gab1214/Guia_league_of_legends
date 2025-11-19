package com.example.guia_league_of_legends.ui.objectives

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.guia_league_of_legends.data.GameMode


@Composable
fun GameModeCard(
    mode: GameMode,
    onClick: (GameMode) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick(mode) },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF231F1F)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            androidx.compose.foundation.Image(
                painter = painterResource(id = mode.mapImageRes),
                contentDescription = mode.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(mode.name, style = MaterialTheme.typography.titleMedium, color = Color(0xFFFFD700))
            Text(mode.description, style = MaterialTheme.typography.bodyMedium, color = Color.White)
        }
    }
}