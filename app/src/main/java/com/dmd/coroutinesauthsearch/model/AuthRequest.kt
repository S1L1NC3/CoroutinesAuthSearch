package com.dmd.coroutinesauthsearch.model

import java.net.PasswordAuthentication

class AuthRequest(
    val username: String,
    val password: String,
    val roles: Array<String>,
    val permission: Array<String>,
    val authToken: String,
    val allRoles: Array<String>,
    val allPermissions: Array<String>,
) : Request()