package com.dmd.coroutinesauthsearch

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dmd.coroutinesauthsearch.databinding.ActivityMainBinding
import com.dmd.coroutinesauthsearch.model.AuthRequest
import com.dmd.coroutinesauthsearch.model.AuthResponse
import com.dmd.coroutinesauthsearch.util.NetworkUtil
import com.dmd.coroutinesauthsearch.vm.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var requestModel: AuthRequest

    @Inject
    lateinit var networkUtil: NetworkUtil

    @Inject
    lateinit var responseModel: AuthResponse

    private val authenticationViewModel: AuthenticationViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        networkUtil.isInternetAvailable(context = applicationContext).also { isConnected ->
            if (isConnected){
                requestModel.username = binding.activityMainEtUsername.text.toString()
                requestModel.password = binding.activityMainEtPassword.text.toString()
                authenticationViewModel.authenticateUser()
                setupObserver()
            } else{

            }

        }

        setContentView(binding.root)
    }

    private fun setupObserver(){
        authenticationViewModel.responseAuth.observe(this, {
            responseModel = it
            Log.d("MertTrackLog", "setupObserver: $responseModel")
        })
    }
}