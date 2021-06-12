package com.dmd.coroutinesauthsearch.api

import com.dmd.coroutinesauthsearch.constants.ApiConstants
import com.dmd.coroutinesauthsearch.model.AuthRequest
import com.dmd.coroutinesauthsearch.model.AuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationApi {
    @Headers(ApiConstants.CONTENT_TYPE_JSON)
    @POST(ApiConstants.AUTH)
    suspend fun auth(@Body authBaseModel: AuthRequest) : Response<AuthResponse>

    @Headers(ApiConstants.CONTENT_TYPE_JSON)
    @POST(ApiConstants.BASIC_AUTH)
    suspend fun basicAuth(@Body authBaseModel: AuthRequest) : Response<AuthResponse>

    @Headers(ApiConstants.CONTENT_TYPE_JSON)
    @POST(ApiConstants.AUTH_TOKEN)
    suspend fun authToken(@Body authBaseModel: AuthRequest) : String

    @Headers(ApiConstants.CONTENT_TYPE_JSON)
    @POST(ApiConstants.BASIC_AUTH_TOKEN)
    suspend fun basicAuthToken(@Body authBaseModel: AuthRequest) : String

    @GET(ApiConstants.AUTH_INFO)
    suspend fun authInfo() : Response<AuthResponse>

    @Headers(ApiConstants.CONTENT_TYPE_JSON)
    @POST(ApiConstants.PROMOTE)
    suspend fun promote(@Body authBaseModel: AuthRequest) : Response<AuthResponse>

}