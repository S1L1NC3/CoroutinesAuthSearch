package com.dmd.coroutinesauthsearch.model

import com.dmd.coroutinesauthsearch.constants.Constants


data class AuthRequest(
    var username: String = Constants.EMPTY_VALUE_STRING,
    var password: String = Constants.EMPTY_VALUE_STRING,
    var roles: List<String> = listOf(),
    var permission: List<String> = listOf(),
    var authToken: String = Constants.EMPTY_VALUE_STRING,
    var allRoles: List<String> = listOf(),
    var allPermissions: List<String> = listOf(),
)