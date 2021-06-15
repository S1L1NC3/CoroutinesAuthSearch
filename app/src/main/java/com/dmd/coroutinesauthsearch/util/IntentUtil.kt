package com.dmd.coroutinesauthsearch.util

import android.content.Context
import android.content.Intent
import com.dmd.coroutinesauthsearch.constants.Constants
import java.io.Serializable

class IntentUtil {
    fun openIntent(from: Context, to: Class<*>){
        val intent = Intent(from, to)
        from.startActivity(intent)
    }

    fun openIntent(from: Context, to: Class<*>, extra: Serializable){
        val intent = Intent(from, to)
        intent.putExtra(Constants.EXTRAS_KEY, extra) //I've used this instead of BuildConfig.APPLICATION_ID
        from.startActivity(intent)
    }
}