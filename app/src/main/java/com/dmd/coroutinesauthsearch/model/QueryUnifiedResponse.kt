package com.dmd.coroutinesauthsearch.model

data class QueryUnifiedResponse(
    val error: Error,
    val estimate: Boolean,
    val fieldDescriptors: List<FieldDescriptor>,
    val frame: List<List<Frame>>,
    val lastUpdate: String,
    val queryId: String,
    val queryTime: Int,
    val queryTimeS: Int,
    val resultCount: Int,
    val stats: Stats,
    val timers: Timers
)