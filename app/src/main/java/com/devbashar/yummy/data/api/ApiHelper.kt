package com.devbashar.yummy.data.api

import com.devbashar.yummy.models.CuisinResponse
import com.devbashar.yummy.models.home.HomeResponse
import com.devbashar.yummy.models.merchnats.MerchantsResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getHome(): Response<HomeResponse>
    suspend fun  getCuisine() : Response<CuisinResponse>
    suspend fun getMerchants(page:Int): Response<MerchantsResponse>
}