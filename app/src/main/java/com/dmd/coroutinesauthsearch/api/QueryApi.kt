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
    suspend fun execute() : Response<QueryExecuteResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(QueryApiConstants.QUERY)
    suspend fun query(@Nullable @Query(QueryApiConstants.E_PARAMETER) E: String) : Response<QueryResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @GET(QueryApiConstants.PARSE_QUERY)
    suspend fun parseQuery(@Query(QueryApiConstants.P_PARAMETER) p: String) : Response<String>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @POST(QueryApiConstants.QUERY_UNIFIED)
    suspend fun queryUnified(@Nullable @Query(QueryApiConstants.E_PARAMETER) E: String) : Response<QueryUnifiedResponse>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @GET(QueryApiConstants.QID)
    suspend fun qid() : Response<String>

    @Headers(Constants.CONTENT_TYPE_JSON)
    @GET(QueryApiConstants.HISTOGRAM_DEFINITIONS)
    suspend fun histogramDefinitions() : Response<HistogramResponse>
}