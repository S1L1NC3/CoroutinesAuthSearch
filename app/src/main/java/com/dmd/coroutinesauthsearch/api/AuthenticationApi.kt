package com.dmd.coroutinesauthsearch.api

import com.dmd.coroutinesauthsearch.constants.AuthApiConstants
import com.dmd.coroutinesauthsearch.constants.Constants
import com.dmd.coroutinesauthsearch.model.AuthRequest
import com.dmd.coroutinesauthsearch.model.AuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationApi {
    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(AuthApiConstants.AUTH)
    suspend fun auth(@Body authBaseModel: AuthRequest) : Response<AuthResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(AuthApiConstants.BASIC_AUTH)
    suspend fun basicAuth(@Body authBaseModel: AuthRequest) : Response<AuthResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(AuthApiConstants.AUTH_TOKEN)
    suspend fun authToken(@Body authBaseModel: AuthRequest) : String

    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(AuthApiConstants.BASIC_AUTH_TOKEN)
    suspend fun basicAuthToken(@Body authBaseModel: AuthRequest) : String

    @GET(AuthApiConstants.AUTH_INFO)
    suspend fun authInfo() : Response<AuthResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(AuthApiConstants.PROMOTE)
    suspend fun promote(@Body authBaseModel: AuthRequest) : Response<AuthResponse>

}