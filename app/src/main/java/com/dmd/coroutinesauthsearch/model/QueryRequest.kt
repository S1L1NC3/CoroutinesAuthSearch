package com.dmd.coroutinesauthsearch.model

import com.dmd.coroutinesauthsearch.constants.Constants

data class QueryRequest(
    var e: String = Constants.EMPTY_VALUE_STRING,
    var p: String = Constants.EMPTY_VALUE_STRING,
)