package com.malushkoaa.feature_main.domain.usecases

import com.malushkoaa.feature_main.domain.repo.MainScreenRepo
import javax.inject.Inject

class GetCategoriesListUseCase @Inject constructor(
    private val repo: MainScreenRepo
) {
    operator fun invoke()=repo.getCategoriesList()
}