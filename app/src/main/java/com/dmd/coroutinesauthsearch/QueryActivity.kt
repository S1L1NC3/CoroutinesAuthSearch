package com.dmd.coroutinesauthsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.dmd.coroutinesauthsearch.databinding.ActivityQueryBinding
import com.dmd.coroutinesauthsearch.util.InputUtil
import com.dmd.coroutinesauthsearch.util.NetworkUtil
import javax.inject.Inject

class QueryActivity : AppCompatActivity() {
    @Inject
    lateinit var networkUtil: NetworkUtil

    @Inject
    lateinit var inputUtil: InputUtil

    private lateinit var binding: ActivityQueryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_query)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.activityQuerySvQuery.setOnSearchClickListener {
            if(inputUtil.isSearchViewInputValid(binding.activityQuerySvQuery)){
                networkUtil.isInternetAvailable(applicationContext).also { isConnected ->
                    if (isConnected){

                    } else {
                        Toast.makeText(applicationContext, resources.getString(R.string.connection_error), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(applicationContext, resources.getString(R.string.input_error_search), Toast.LENGTH_SHORT).show()
            }

        }
    }
}