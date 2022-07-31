package com.malushkoaa.feature_main.data.localdatasource


import com.malushkoaa.feature_main.R
import com.malushkoaa.feature_main.data.localdatasource.model.CategoriesDataModel
import javax.inject.Inject

class MainScreenDataSource @Inject constructor() {

    val categoriesList: List<CategoriesDataModel> = listOf(
        CategoriesDataModel(
            0,
            "Phones",
            R.drawable.ic_category_phone
        ),
        CategoriesDataModel(
            1,
            "Computer",
            R.drawable.ic_category_computer
        ),
        CategoriesDataModel(
            2,
            "Health",
            R.drawable.ic_category_health
        ),
        CategoriesDataModel(
            3,
            "Books",
            R.drawable.ic_category_books
        ),
        CategoriesDataModel(
            4,
            "Pets",
            R.drawable.ic_category_pets
        )
    )
}