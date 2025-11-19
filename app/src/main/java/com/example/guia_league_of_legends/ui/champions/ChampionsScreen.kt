package com.example.guia_league_of_legends.ui.champions

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.guia_league_of_legends.viewmodel.ChampionViewModel
import com.example.guia_league_of_legends.data.LaneRole
import com.example.guia_league_of_legends.ui.components.ChampionCard

@Composable
fun ChampionsScreen(
    viewModel: ChampionViewModel,
    navController: NavController,
    modifier: Modifier = Modifier,
    roleFilter: LaneRole? = null
) {
    val championsState = viewModel.champions.collectAsState()

    LaunchedEffect(roleFilter) {
        viewModel.loadChampions(roleFilter)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
            .padding(horizontal = 16.dp)
    ) {
        items(championsState.value) { champion ->
            ChampionCard(champion) {
                navController.navigate("championDetail/${champion.id}")
            }
        }
    }
}