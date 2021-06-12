package com.dmd.coroutinesauthsearch.api

import com.dmd.coroutinesauthsearch.constants.ApiConstants
import com.dmd.coroutinesauthsearch.model.Request
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthenticationApi {
    @POST(ApiConstants.AUTH)
    suspend fun auth(@Body authRequest: Request)

    @POST(ApiConstants.BASIC_AUTH)
    suspend fun basicAuth(@Body authRequest: Request)

    @POST(ApiConstants.AUTH_TOKEN)
    suspend fun authToken(@Body authRequest: Request)

    @POST(ApiConstants.BASIC_AUTH_TOKEN)
    suspend fun basicAuthToken(@Body authRequest: Request)

    @GET(ApiConstants.AUTH_INFO)
    suspend fun authInfo()

    @POST(ApiConstants.PROMOTE)
    suspend fun promote(@Body authRequest: Request)

}