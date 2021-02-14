package com.devbashar.yummy.models.merchnats


import com.google.gson.annotations.SerializedName

data class MerchantsResponse(
    @SerializedName("data")
    val `data`: List<Merchant>?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?
)