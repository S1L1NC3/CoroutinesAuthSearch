package com.dmd.coroutinesauthsearch.model

data class ExceptionObject(
    val cause: Cause,
    val localizedMessage: String,
    val message: String,
    val stackTrace: List<StackTrace>,
    val suppressed: List<Suppressed>
)