package com.dmd.coroutinesauthsearch.api

import androidx.annotation.Nullable
import com.dmd.coroutinesauthsearch.constants.AuthApiConstants
import com.dmd.coroutinesauthsearch.constants.Constants
import com.dmd.coroutinesauthsearch.constants.QueryApiConstants
import com.dmd.coroutinesauthsearch.model.*
import retrofit2.Response
import retrofit2.http.*

interface QueryApi {
    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(QueryApiConstants.EXECUTE)
    suspend fun execute(
        @Header(Constants.AUTHORIZATION) token: String
    ) : Response<QueryExecuteResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(QueryApiConstants.QUERY)
    suspend fun query(
        @Header(Constants.AUTHORIZATION) token: String,
        @Nullable @Query(QueryApiConstants.E_PARAMETER) E: String
    ) : Response<QueryResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @GET(QueryApiConstants.PARSE_QUERY)
    suspend fun parseQuery(
        @Header(Constants.AUTHORIZATION) token: String,
        @Query(QueryApiConstants.P_PARAMETER) p: String
    ) : Response<String>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(QueryApiConstants.QUERY_UNIFIED)
    suspend fun queryUnified(
        @Header(Constants.AUTHORIZATION) token: String,
        @Nullable @Query(QueryApiConstants.E_PARAMETER) E: String
    ) : Response<QueryUnifiedResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @GET(QueryApiConstants.QID)
    suspend fun qid(
        @Header(Constants.AUTHORIZATION) token: String
    ) : Response<String>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @GET(QueryApiConstants.HISTOGRAM_DEFINITIONS)
    suspend fun histogramDefinitions(
        @Header(Constants.AUTHORIZATION) token: String
    ) : Response<HistogramResponse>
}