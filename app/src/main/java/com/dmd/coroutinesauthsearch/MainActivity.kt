package com.dmd.coroutinesauthsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.dmd.coroutinesauthsearch.databinding.ActivityMainBinding
import com.dmd.coroutinesauthsearch.model.AuthRequest
import com.dmd.coroutinesauthsearch.util.NetworkUtil
import com.dmd.coroutinesauthsearch.vm.AuthenticationViewModel
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var requestModel: AuthRequest

    @Inject
    lateinit var networkUtil: NetworkUtil

    private val authenticationViewModel: AuthenticationViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        networkUtil.isInternetAvailable(context = applicationContext).also { isConnected ->
            if (isConnected){
                requestModel.username = "DasIstGut"
                requestModel.password = "IstDasGut"
                authenticationViewModel.authenticateUser()
            } else{

            }
            Log.d("MertTrackLog", "onCreate: $isConnected")

        }

        setContentView(binding.root)
    }
}