package com.dmd.coroutinesauthsearch.model

data class Suppressed(
    val localizedMessage: String,
    val message: String,
    val stackTrace: List<StackTrace>
)