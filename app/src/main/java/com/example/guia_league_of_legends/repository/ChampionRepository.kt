package com.example.guia_league_of_legends.repository

import com.example.guia_league_of_legends.data.Champion
import com.example.guia_league_of_legends.data.ChampionDetail
import com.example.guia_league_of_legends.data.ChampionInfo
import com.example.guia_league_of_legends.data.ChampionStats
import com.example.guia_league_of_legends.data.LaneRole
import com.example.guia_league_of_legends.utils.JsonLoader
import org.json.JSONArray
import org.json.JSONObject

class ChampionRepository(private val jsonLoader: JsonLoader) {

    fun loadChampions(): List<Champion> {
        val json = jsonLoader.loadJson("champions.json")
        val jsonArray = JSONArray(json)
        val champions = mutableListOf<Champion>()

        for (i in 0 until jsonArray.length()) {
            val obj = jsonArray.getJSONObject(i)

            val laneRolesArray = obj.optJSONArray("laneRoles") ?: JSONArray()
            val laneRoles = List(laneRolesArray.length()) {
                LaneRole.valueOf(laneRolesArray.getString(it).uppercase())
            }

            champions.add(
                Champion(
                    id = obj.getString("id"),
                    name = obj.getString("name"),
                    role = obj.getString("role"),
                    description = obj.getString("description"),
                    imageUrl = obj.getString("imageUrl"),
                    laneRoles = laneRoles
                )
            )
        }
        return champions
    }

    fun loadChampionDetail(id: String): ChampionDetail? {
        val json = jsonLoader.loadJson("champions_full.json")
        val data = JSONObject(json).getJSONObject("data").getJSONObject(id)

        val infoObj = data.getJSONObject("info")
        val statsObj = data.getJSONObject("stats")
        val tagsArray = data.getJSONArray("tags")
        val tags = List(tagsArray.length()) { tagsArray.getString(it) }

        return ChampionDetail(
            id = data.getString("id"),
            title = data.optString("title", ""),
            blurb = data.getString("blurb"),
            info = ChampionInfo(
                attack = infoObj.getInt("attack"),
                defense = infoObj.getInt("defense"),
                magic = infoObj.getInt("magic"),
                difficulty = infoObj.getInt("difficulty")
            ),
            tags = tags,
            stats = ChampionStats(
                hp = statsObj.optDouble("hp", 0.0),
                hpperlevel = statsObj.optDouble("hpperlevel", 0.0),
                mp = statsObj.optDouble("mp", 0.0),
                mpperlevel = statsObj.optDouble("mpperlevel", 0.0),
                movespeed = statsObj.optDouble("movespeed", 0.0),
                armor = statsObj.optDouble("armor", 0.0),
                armorperlevel = statsObj.optDouble("armorperlevel", 0.0),
                spellblock = statsObj.optDouble("spellblock", 0.0),
                spellblockperlevel = statsObj.optDouble("spellblockperlevel", 0.0),
                attackrange = statsObj.optDouble("attackrange", 0.0),
                hpregen = statsObj.optDouble("hpregen", 0.0),
                hpregenperlevel = statsObj.optDouble("hpregenperlevel", 0.0),
                mpregen = statsObj.optDouble("mpregen", 0.0),
                mpregenperlevel = statsObj.optDouble("mpregenperlevel", 0.0),
                crit = statsObj.optDouble("crit", 0.0),
                critperlevel = statsObj.optDouble("critperlevel", 0.0),
                attackdamage = statsObj.optDouble("attackdamage", 0.0),
                attackdamageperlevel = statsObj.optDouble("attackdamageperlevel", 0.0),
                attackspeed = statsObj.optDouble("attackspeed", 0.0),
                attackspeedperlevel = statsObj.optDouble("attackspeedperlevel", 0.0)
            )

        )
    }
}