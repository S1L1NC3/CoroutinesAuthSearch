package com.dmd.coroutinesauthsearch.model

data class S(
    val count: Int,
    val negative: Int,
    val normalisedNegative: Int,
    val normalisedPositive: Int,
    val normalisedTotal: Int,
    val positive: Int,
    val scaledTotal: Int,
    val total: Int
)