package com.dmd.coroutinesauthsearch.model

data class StackTrace(
    val classLoaderName: String,
    val className: String,
    val fileName: String,
    val lineNumber: Int,
    val methodName: String,
    val moduleName: String,
    val moduleVersion: String,
    val nativeMethod: Boolean
)