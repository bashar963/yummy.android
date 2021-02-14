package com.devbashar.yummy.models.home


import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("data")
    val `data`: List<Section>?,
    @SerializedName("status")
    val status: String?
)