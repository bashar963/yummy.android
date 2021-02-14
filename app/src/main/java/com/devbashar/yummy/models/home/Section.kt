package com.devbashar.yummy.models.home


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("display_order")
    val displayOrder: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("merchants")
    val merchants: List<Merchant>?,
    @SerializedName("offers")
    val offers: List<Offer>?,
    @SerializedName("section_id")
    val sectionId: String?,
    @SerializedName("section_title")
    val sectionTitle: String?,
    @SerializedName("state_id")
    val stateId: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("title_ar")
    val titleAr: String?
)