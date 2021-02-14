package com.devbashar.yummy.models.home


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("city_id")
    val cityId: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("name_ar")
    val nameAr: String?
)