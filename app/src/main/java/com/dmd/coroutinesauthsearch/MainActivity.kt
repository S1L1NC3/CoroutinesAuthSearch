package com.dmd.coroutinesauthsearch

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dmd.coroutinesauthsearch.databinding.ActivityMainBinding
import com.dmd.coroutinesauthsearch.model.AuthRequest
import com.dmd.coroutinesauthsearch.model.AuthResponse
import com.dmd.coroutinesauthsearch.util.InputUtil
import com.dmd.coroutinesauthsearch.util.IntentUtil
import com.dmd.coroutinesauthsearch.util.NetworkUtil
import com.dmd.coroutinesauthsearch.util.SerializationUtil
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

    @Inject
    lateinit var inputUtil: InputUtil

    @Inject
    lateinit var intentUtil: IntentUtil

    @Inject
    lateinit var serializationUtil: SerializationUtil

    private val authenticationViewModel: AuthenticationViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private  var isPasswordVisible: Boolean = true //Didn't included to AppModule because it's a small variable I mean
    private  var isObserverSetupAlready: Boolean = false //Didn't included to AppModule because it's a small variable I mean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    private fun setupObserver(){
        authenticationViewModel.responseAuth.observe(this, {
            responseModel = it
        })
        authenticationViewModel.isLoading.observe(this, { isLoading ->
            if (isLoading) Log.d("MertTrackLog", "setupObserver: $isLoading") else Log.d("MertTrackLog", "setupObserver: $isLoading")
        })
        authenticationViewModel.isSuccess.observe(this, { isSuccessful ->
            if (isSuccessful) intentUtil.openIntent(this, QueryActivity::class.java)
        })
        authenticationViewModel.isError.observe(this, {
            Toast.makeText(applicationContext, serializationUtil.getErrorMessage(it),Toast.LENGTH_SHORT).show()
        })
        isObserverSetupAlready = true
    }

    fun showHidePassword(view: View) {
        if(isPasswordVisible){
            binding.activityMainEtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else{
            binding.activityMainEtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        isPasswordVisible = !isPasswordVisible
    }

    fun login(view: View) {
        networkUtil.isInternetAvailable(context = applicationContext).also { isConnected ->
            if (isConnected){
                if (inputUtil.isEditTextInputValid(binding.activityMainEtUsername) && inputUtil.isEditTextInputValid(binding.activityMainEtPassword)){
                    requestModel.username = binding.activityMainEtUsername.text.toString()
                    requestModel.password = binding.activityMainEtPassword.text.toString()
                    authenticationViewModel.authenticateUser()
                    if (!isObserverSetupAlready){
                        setupObserver()
                    }
                } else {
                    Toast.makeText(applicationContext, resources.getString(R.string.input_error), Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(applicationContext, resources.getString(R.string.connection_error), Toast.LENGTH_SHORT).show()
            }
        }
    }
}