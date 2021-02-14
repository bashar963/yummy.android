package com.devbashar.yummy.data.api

import com.devbashar.yummy.models.CuisinResponse
import com.devbashar.yummy.models.home.HomeResponse
import com.devbashar.yummy.models.merchnats.MerchantsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{

    @GET("mobileapp/api/home-api?st=1&sarea=1&category=&type=api&lat=43.566&lng=56.5656565")
    suspend fun getHome(): Response<HomeResponse>

    @GET("mobileapp/api/CuisineListNew2")
    suspend fun getCuisines(): Response<CuisinResponse>


    @GET("mobileapp/api/merchants?client_id=0&state_id=1&latitude=43.566&longitude=56.5656565&type=restaurant")
    suspend fun getMerchants(@Query("page") page:Int ): Response<MerchantsResponse>
}