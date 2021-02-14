package com.devbashar.yummy.data.repository

import com.devbashar.yummy.data.api.ApiHelper
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiHelper: ApiHelper
){

    suspend fun getHome() = apiHelper.getHome()

    suspend fun getCuisines() = apiHelper.getCuisine()

    suspend fun getMerchants(page:Int) = apiHelper.getMerchants(page)
}