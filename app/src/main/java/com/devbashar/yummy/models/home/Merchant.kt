package com.devbashar.yummy.models.home


import com.google.gson.annotations.SerializedName

data class Merchant(
    @SerializedName("abn")
    val abn: String?,
    @SerializedName("actual_delivery_charge")
    val actualDeliveryCharge: String?,
    @SerializedName("area_id")
    val areaId: String?,
    @SerializedName("average_delivery_charge")
    val averageDeliveryCharge: Any?,
    @SerializedName("average_delivery_time")
    val averageDeliveryTime: String?,
    @SerializedName("average_rating")
    val averageRating: Any?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("city_id")
    val cityId: String?,
    @SerializedName("commision_type")
    val commisionType: String?,
    @SerializedName("country_id")
    val countryId: String?,
    @SerializedName("country_name")
    val countryName: String?,
    @SerializedName("cuisine")
    val cuisine: String?,
    @SerializedName("delivery_charges")
    val deliveryCharges: String?,
    @SerializedName("delivery_estimation")
    val deliveryEstimation: String?,
    @SerializedName("delivery_maximum_order")
    val deliveryMaximumOrder: String?,
    @SerializedName("delivery_minimum_order")
    val deliveryMinimumOrder: String?,
    @SerializedName("delivery_time")
    val deliveryTime: String?,
    @SerializedName("distance")
    val distance: Double?,
    @SerializedName("enabled_per_km_delivery_price")
    val enabledPerKmDeliveryPrice: Any?,
    @SerializedName("free_delivery")
    val freeDelivery: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image_path")
    val imagePath: String?,
    @SerializedName("is_commission")
    val isCommission: String?,
    @SerializedName("is_featured")
    val isFeatured: String?,
    @SerializedName("is_ready")
    val isReady: String?,
    @SerializedName("is_sponsored")
    val isSponsored: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("logo")
    val logo: String?,
    @SerializedName("lontitude")
    val lontitude: String?,
    @SerializedName("membership_expired")
    val membershipExpired: String?,
    @SerializedName("membership_purchase_date")
    val membershipPurchaseDate: String?,
    @SerializedName("merchant_delivery_discount_for_per_km_active")
    val merchantDeliveryDiscountForPerKmActive: String?,
    @SerializedName("merchant_id")
    val merchantId: String?,
    @SerializedName("merchant_key")
    val merchantKey: String?,
    @SerializedName("merchant_photo_bg")
    val merchantPhotoBg: String?,
    @SerializedName("merchant_type")
    val merchantType: String?,
    @SerializedName("mid")
    val mid: String?,
    @SerializedName("minimum_order")
    val minimumOrder: String?,
    @SerializedName("opening_status")
    val openingStatus: String?,
    @SerializedName("package_id")
    val packageId: String?,
    @SerializedName("package_price")
    val packagePrice: String?,
    @SerializedName("payment_steps")
    val paymentSteps: String?,
    @SerializedName("percent_commision")
    val percentCommision: String?,
    @SerializedName("pickup_maximum_order")
    val pickupMaximumOrder: String?,
    @SerializedName("pickup_minimum_order")
    val pickupMinimumOrder: String?,
    @SerializedName("post_code")
    val postCode: String?,
    @SerializedName("preferredPickup")
    val preferredPickup: String?,
    @SerializedName("rating_total")
    val ratingTotal: Any?,
    @SerializedName("restaurant_name")
    val restaurantName: String?,
    @SerializedName("restaurant_name_ar")
    val restaurantNameAr: String?,
    @SerializedName("restaurant_slug")
    val restaurantSlug: String?,
    @SerializedName("section_id")
    val sectionId: String?,
    @SerializedName("service")
    val service: String?,
    @SerializedName("sort_featured")
    val sortFeatured: String?,
    @SerializedName("sponsored_expiration")
    val sponsoredExpiration: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("state_id")
    val stateId: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total_rating")
    val totalRating: Any?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("wedeliver_time")
    val wedDeliverTime: String?
)