package com.example.guia_league_of_legends.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.guia_league_of_legends.data.LaneRole
import com.example.guia_league_of_legends.ui.champions.ChampionDetailScreen
import com.example.guia_league_of_legends.ui.champions.ChampionsScreen
import com.example.guia_league_of_legends.ui.home.HomeScreen
import com.example.guia_league_of_legends.ui.objectives.GameModeDetailScreen
import com.example.guia_league_of_legends.ui.objectives.ObjectivesScreen
import com.example.guia_league_of_legends.ui.profile.ProfileScreen
import com.example.guia_league_of_legends.viewmodel.ChampionViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: ChampionViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // 🏠 Pantalla principal
        composable("home") {
            HomeScreen(navController)
        }

        // 🧩 Lista completa de campeones
        composable("champions") {
            ChampionsScreen(
                viewModel = viewModel,
                navController = navController,
                modifier = modifier,
                roleFilter = null
            )
        }

        // 🧩 Lista filtrada por línea (desde Home)
        composable("champions/{role}") { backStackEntry ->
            val roleName = backStackEntry.arguments?.getString("role")
            val role = LaneRole.entries.find { it.name == roleName }
            ChampionsScreen(
                viewModel = viewModel,
                navController = navController,
                modifier = modifier,
                roleFilter = role
            )
        }

        // 🔍 Detalle del campeón
        composable("championDetail/{championId}") { backStackEntry ->
            val championId = backStackEntry.arguments?.getString("championId") ?: ""
            ChampionDetailScreen(championId, viewModel)
        }
        composable("Modos") {
            ObjectivesScreen(
                navController = navController,
                modifier = modifier
            )
        }


        composable("modeDetail/{modeId}") { backStackEntry ->
            val modeId = backStackEntry.arguments?.getString("modeId") ?: ""
            GameModeDetailScreen(modeId)
        }


        composable("profile") {
            ProfileScreen()
        }


    }
}