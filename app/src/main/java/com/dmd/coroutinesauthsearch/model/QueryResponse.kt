package com.dmd.coroutinesauthsearch.model

data class QueryResponse(
    val error: Error,
    val estimate: Boolean,
    val lastUpdate: String,
    val queryId: String,
    val queryTime: Int,
    val queryTimeS: Int,
    val resultCount: Int,
    val results: List<Result>,
    val stats: Stats,
    val timers: Timers
)