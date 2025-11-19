package com.example.guia_league_of_legends.viewmodel

import androidx.lifecycle.ViewModel
import com.example.guia_league_of_legends.data.*
import com.example.guia_league_of_legends.repository.ChampionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChampionViewModel(private val repository: ChampionRepository) : ViewModel() {
    private val _champions = MutableStateFlow<List<Champion>>(emptyList())
    val champions: StateFlow<List<Champion>> = _champions

    init {
        loadChampions()
    }

    fun loadChampions(filterRole: LaneRole? = null) {
        val allChampions = repository.loadChampions()
        _champions.value = if (filterRole != null) {
            allChampions.filter { it.laneRoles.contains(filterRole) }
        } else {
            allChampions
        }
    }

    fun loadChampionDetail(id: String): ChampionDetail? {
        return repository.loadChampionDetail(id)
    }
    fun getChampionWithDetail(id: String): Pair<Champion, ChampionDetail>? {
        val basic = repository.loadChampions().find { it.id == id }
        val detail = repository.loadChampionDetail(id)

        return if (basic != null && detail != null) {
            Pair(basic, detail)
        } else null
    }
}