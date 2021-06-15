package com.dmd.coroutinesauthsearch.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmd.coroutinesauthsearch.data.AuthenticationRepository
import com.dmd.coroutinesauthsearch.model.AuthResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {
    private val _response = MutableLiveData<AuthResponse>()

    val responseAuth: LiveData<AuthResponse> //To Retrieve Data From VM
        get() = _response

    fun authenticateUser(){
        authenticate()
    }

    private fun authenticate() = viewModelScope.launch {
        authenticationRepository.authenticate().let { response ->
            if (response.isSuccessful){
                Log.d("MertTrackLog", "authenticateUser: ${response.body()}")
                _response.postValue(response.body())
            } else {
                Log.d("MertTrackLog", "authenticateUser: ${response.body()}")

            }
        }
    }
}