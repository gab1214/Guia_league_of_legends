package com.example.guia_league_of_legends.utils

import android.content.Context

class JsonLoader(private val context: Context) {
    fun loadJson(fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}