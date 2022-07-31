package com.malushkoaa.feature_main.data.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhonesResponseModel(
    @Json(name = "best_seller") val bestSellers: List<BestSellerDto>,
    @Json(name = "home_store") val hotSales: List<HotSaleDto>
) : Parcelable