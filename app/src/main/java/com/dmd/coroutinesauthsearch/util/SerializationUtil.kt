package com.dmd.coroutinesauthsearch.util

import android.content.res.Resources
import com.dmd.coroutinesauthsearch.R
import com.dmd.coroutinesauthsearch.model.ErrorResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SerializationUtil {
    fun getErrorMessage(errorBody: String): String{
        val gson = Gson()
        val type = object : TypeToken<ErrorResponse>(){}.type
        val errorResponse: ErrorResponse? = gson.fromJson(errorBody, type)
        return errorResponse?.message ?: Resources.getSystem().getString(R.string.username_password_wrong)
    }
}