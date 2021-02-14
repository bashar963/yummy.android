package com.devbashar.yummy.models

import com.google.gson.annotations.SerializedName


data class CuisinResponse (
        val code: Int,
        val msg: String,
        val details: List<Detail>,
        val request: String
)

data class Detail (
        val cusisine: Cusisine
)

data class Cusisine (
        @SerializedName("cuisine_id")
        val cuisineID: String,

        @SerializedName("cuisine_name")
        val cuisineName: String,

        val image: String
)