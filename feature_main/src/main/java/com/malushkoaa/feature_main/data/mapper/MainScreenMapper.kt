package com.malushkoaa.feature_main.data.mapper

import com.malushkoaa.feature_main.data.localdatasource.model.CategoriesDataModel
import com.malushkoaa.feature_main.data.network.models.BestSellerDto
import com.malushkoaa.feature_main.data.network.models.HotSaleDto
import com.malushkoaa.feature_main.domain.entities.BestSeller
import com.malushkoaa.feature_main.domain.entities.Categories
import com.malushkoaa.feature_main.domain.entities.HotSale
import javax.inject.Inject

class MainScreenMapper @Inject constructor(){

    fun mapDtoToEntity(dto: BestSellerDto) = BestSeller(
        discountPrice = convertPrice(dto.discountPrice ?: 0),
        id = dto.id,
        isFavorites = dto.isFavorites,
        picture = dto.picture,
        priceWithoutDiscount = convertPrice(dto.priceWithoutDiscount ?: 0),
        title = dto.title
    )

    fun madDtoToEntity(dto: HotSaleDto) = HotSale(
        id = dto.id,
        isBuy = dto.isBuy,
        isNew = dto.isNew,
        picture = dto.picture,
        subtitle = dto.subtitle,
        title = dto.title
    )

    fun mapDbModelToEntity(dbModel: CategoriesDataModel) = Categories(
        id = dbModel.id,
        name = dbModel.name,
        image = dbModel.image
    )


    private fun convertPrice(price: Int): String {
        val bufferPrice = StringBuilder(price.toString())
        val convertedPrice =
            if (price >= 1000) {
                bufferPrice.insert(1, ",")
            } else if (price >= 10000) {
                bufferPrice.insert(2, ",")
            } else {
                price.toString()
            }
        return "$convertedPrice"
    }
}