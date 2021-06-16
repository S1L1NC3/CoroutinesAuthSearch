package com.dmd.coroutinesauthsearch.data

import com.dmd.coroutinesauthsearch.api.AuthenticationApi
import com.dmd.coroutinesauthsearch.model.AuthRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationRepository @Inject constructor(
    private var authenticationApi: AuthenticationApi
) {
    @Inject
    lateinit var authRequest: AuthRequest

    suspend fun authenticate() = authenticationApi.auth(authRequest)

    suspend fun basicAuth() = authenticationApi.basicAuth(authRequest)

    suspend fun authToken() = authenticationApi.authToken(authRequest)

    suspend fun basicAuthToken() = authenticationApi.basicAuthToken(authRequest)

    suspend fun authInfo() = authenticationApi.authInfo()

    suspend fun promote() = authenticationApi.promote(authRequest)
}