package com.dmd.coroutinesauthsearch.model

data class Cause(
    val localizedMessage: String,
    val message: String,
    val stackTrace: List<StackTrace>,
    val suppressed: List<Suppressed>
)