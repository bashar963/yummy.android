package com.devbashar.yummy.data.api

import com.devbashar.yummy.models.CuisinResponse
import com.devbashar.yummy.models.home.HomeResponse
import com.devbashar.yummy.models.merchnats.MerchantsResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
):ApiHelper{
    override suspend fun getHome(): Response<HomeResponse> = apiService.getHome()
    override suspend fun getCuisine(): Response<CuisinResponse> = apiService.getCuisines()
    override suspend fun getMerchants(page:Int): Response<MerchantsResponse> = apiService.getMerchants(page)

}