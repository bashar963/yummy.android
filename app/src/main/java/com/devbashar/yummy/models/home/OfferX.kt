package com.devbashar.yummy.models.home


import com.google.gson.annotations.SerializedName

data class OfferX(
    @SerializedName("city_list")
    val cityList: List<City>?,
    @SerializedName("custom_amount")
    val customAmount: Any?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("description_ar")
    val descriptionAr: String?,
    @SerializedName("discounted_item")
    val discountedItem: String?,
    @SerializedName("fixed_item_discount")
    val fixedItemDiscount: String?,
    @SerializedName("item_offered_price")
    val itemOfferedPrice: String?,
    @SerializedName("offer_buyperdisc")
    val offerBuyperdisc: String?,
    @SerializedName("offer_fixed")
    val offerFixed: String?,
    @SerializedName("offer_image")
    val offerImage: String?,
    @SerializedName("offer_percentage")
    val offerPercentage: String?,
    @SerializedName("offer_price")
    val offerPrice: String?,
    @SerializedName("offer_type")
    val offerType: String?,
    @SerializedName("offered_item")
    val offeredItem: String?,
    @SerializedName("offers_id")
    val offersId: String?,
    @SerializedName("period_date")
    val periodDate: String?,
    @SerializedName("salutes")
    val salutes: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("title_ar")
    val titleAr: String?,
    @SerializedName("valid_from")
    val validFrom: String?,
    @SerializedName("valid_to")
    val validTo: String?
)