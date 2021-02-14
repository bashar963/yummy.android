package com.devbashar.yummy.models.home


import com.google.gson.annotations.SerializedName

data class Ratings(
    @SerializedName("ratings")
    val ratings: String?,
    @SerializedName("votes")
    val votes: String?
)