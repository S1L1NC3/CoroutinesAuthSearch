package com.dmd.coroutinesauthsearch.vm

import com.dmd.coroutinesauthsearch.data.QueryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QueryViewModel @Inject constructor(
    private val queryRepository: QueryRepository
) {
}