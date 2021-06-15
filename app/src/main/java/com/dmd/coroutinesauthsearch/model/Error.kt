package com.dmd.coroutinesauthsearch.model

data class Error(
    val exception: String,
    val exceptionObject: ExceptionObject,
    val message: String,
    val rootAt: String,
    val rootException: String,
    val rootMessage: String,
    val stack: String
)