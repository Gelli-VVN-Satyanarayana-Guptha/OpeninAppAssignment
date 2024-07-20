package com.example.openinappassignment.domain.model

data class ListsData (
    var recentLinks     : List<LinkData>? = null,
    var topLinks        : List<LinkData>? = null,
    var favouriteLinks  : List<LinkData>? = null,
    var overallUrlChart : Map<String, Int>? = null
)
