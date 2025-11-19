package com.example.guia_league_of_legends.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.guia_league_of_legends.viewmodel.ChampionViewModel

@Composable
fun AppNavigation(viewModel: ChampionViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color(0xFF0F0F0F)
    ) { innerPadding ->
        NavGraph(
            navController = navController,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )

    }
}