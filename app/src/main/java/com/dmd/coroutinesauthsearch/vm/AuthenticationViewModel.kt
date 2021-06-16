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
    private val _loading = MutableLiveData<Boolean>()
    private val _isSuccess = MutableLiveData<Boolean>()
    private val _isError = MutableLiveData<String>()

    val responseAuth: LiveData<AuthResponse> //To Retrieve Data From VM
        get() = _response
    val isLoading: LiveData<Boolean>
        get() = _loading
    val isSuccess: LiveData<Boolean>
        get() = _isSuccess
    val isError: LiveData<String>
        get() = _isError

    fun authenticateUser(){
        authenticate()
    }

    private fun authenticate() = viewModelScope.launch {
        _loading.postValue(true)
        authenticationRepository.authenticate().let { response ->
            _loading.postValue(false)
            _isSuccess.postValue(response.isSuccessful) //True & False comes from isSuccessful method
            if (response.isSuccessful){
                _response.postValue(response.body())
            } else {
                _isError.postValue(response.errorBody()?.string())
            }
        }
    }
}