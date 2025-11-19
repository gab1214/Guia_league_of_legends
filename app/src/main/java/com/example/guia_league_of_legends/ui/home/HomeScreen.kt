package com.example.guia_league_of_legends.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.guia_league_of_legends.R
import com.example.guia_league_of_legends.data.LaneRole

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Guía de la Grieta",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFFFFD700)
        )


        RoleButton("TOP", R.drawable.ic_top, navController)
        RoleButton("JUNGLA", R.drawable.ic_jungla, navController)
        RoleButton("MID", R.drawable.ic_mid, navController)
        RoleButton("ADC", R.drawable.ic_adc, navController)
        RoleButton("SOPORTE", R.drawable.ic_soporte, navController)
    }

}


