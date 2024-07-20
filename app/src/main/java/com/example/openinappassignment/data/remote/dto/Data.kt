package com.example.openinappassignment.data.remote.dto

import com.example.openinappassignment.domain.model.ListsData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("recent_links"      ) var recentLinks     : List<Link>?,
    @SerialName("top_links"         ) var topLinks        : List<Link>?,
    @SerialName("favourite_links"   ) var favouriteLinks  : List<Link>?,
    @SerialName("overall_url_chart" ) var overallUrlChart : Map<String, Int>?
) {
    fun toListsData(): ListsData {
        return ListsData (
            recentLinks = recentLinks?.map { it.toLinkData() },
            topLinks = topLinks?.map { it.toLinkData() },
            favouriteLinks = favouriteLinks?.map { it.toLinkData() },
            overallUrlChart = overallUrlChart
        )
    }
}
