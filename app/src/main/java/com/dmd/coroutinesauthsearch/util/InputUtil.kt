package com.dmd.coroutinesauthsearch.util

import android.view.View
import android.widget.EditText

class InputUtil {
    fun isEditTextInputValid(view: View): Boolean{
        return try{
            val editTextToCheck = view as EditText
            if (editTextToCheck.text != null){
                return editTextToCheck.text.toString().isNotEmpty()
            } else {
                throw Exception()
            }
        } catch (e: Exception){
            false
        }
    }
}