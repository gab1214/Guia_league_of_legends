package com.example.guia_league_of_legends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.guia_league_of_legends.repository.ChampionRepository
import com.example.guia_league_of_legends.ui.navigation.AppNavigation
import com.example.guia_league_of_legends.ui.theme.LeagueGuideTheme
import com.example.guia_league_of_legends.utils.JsonLoader
import com.example.guia_league_of_legends.viewmodel.ChampionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = ChampionRepository(JsonLoader(this))
        val viewModel = ChampionViewModel(repository)

        setContent {
            LeagueGuideTheme {
                AppNavigation(viewModel = viewModel)
            }
        }
    }
}
