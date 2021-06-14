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
}