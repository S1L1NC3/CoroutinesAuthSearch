package com.dmd.coroutinesauthsearch.model

data class AuthResponse(
    val username: String,
    val password: String,
    val roles: List<String>,
    val permission: List<String>,
    val authToken: String,
    val allRoles: List<String>,
    val allPermissions: List<String>,
)