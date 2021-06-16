package com.dmd.coroutinesauthsearch.util

import android.view.View
import android.widget.EditText
import android.widget.SearchView

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

    fun isSearchViewInputValid(view: View): Boolean{
        return try{
            val editTextToCheck = view as SearchView
            if (editTextToCheck.query != null){
                return editTextToCheck.query.toString().isNotEmpty()
            } else {
                throw Exception()
            }
        } catch (e: Exception){
            false
        }
    }
}