package com.devbashar.yummy.models.home


import com.google.gson.annotations.SerializedName

data class Offer(
    @SerializedName("address")
    val address: String?,
    @SerializedName("contact_phone")
    val contactPhone: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("cover_image")
    val coverImage: String?,
    @SerializedName("cuisine")
    val cuisine: String?,
    @SerializedName("delivery_fee")
    val deliveryFee: String?,
    @SerializedName("delivery_fee_raw")
    val deliveryFeeRaw: String?,
    @SerializedName("free_delivery")
    val freeDelivery: Int?,
    @SerializedName("free_message")
    val freeMessage: String?,
    @SerializedName("free_price")
    val freePrice: String?,
    @SerializedName("free_price_pretty")
    val freePricePretty: String?,
    @SerializedName("logo")
    val logo: String?,
    @SerializedName("merchant_close_store")
    val merchantCloseStore: Boolean?,
    @SerializedName("merchant_id")
    val merchantId: String?,
    @SerializedName("minimum_order")
    val minimumOrder: String?,
    @SerializedName("minimum_order_raw")
    val minimumOrderRaw: String?,
    @SerializedName("offers")
    val offers: List<OfferX>?,
    @SerializedName("offers_found")
    val offersFound: Int?,
    @SerializedName("open")
    val `open`: Boolean?,
    @SerializedName("ratings")
    val ratings: Ratings?,
    @SerializedName("restaurant_name")
    val restaurantName: String?,
    @SerializedName("restaurant_name_ar")
    val restaurantNameAr: String?,
    @SerializedName("service")
    val service: String?,
    @SerializedName("street_ar")
    val streetAr: String?
)