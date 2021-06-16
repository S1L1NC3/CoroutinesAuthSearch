package com.dmd.coroutinesauthsearch.data

import com.dmd.coroutinesauthsearch.api.QueryApi
import com.dmd.coroutinesauthsearch.model.AuthResponse
import com.dmd.coroutinesauthsearch.model.QueryRequest
import javax.inject.Inject

class QueryRepository @Inject constructor(
    private val queryApi: QueryApi
) {
    @Inject
    lateinit var queryRequest: QueryRequest

    @Inject
    lateinit var authResponse: AuthResponse //To get bearer token from login

    suspend fun execute() = queryApi.execute(authResponse.authToken)

    suspend fun query() = queryApi.query(authResponse.authToken, queryRequest.e)

    suspend fun parseQuery() = queryApi.parseQuery(authResponse.authToken, queryRequest.p)

    suspend fun queryUnified() = queryApi.queryUnified(authResponse.authToken, queryRequest.e)

    suspend fun qid() = queryApi.qid(authResponse.authToken)

    suspend fun histogramDefinitions() = queryApi.histogramDefinitions(authResponse.authToken)


}