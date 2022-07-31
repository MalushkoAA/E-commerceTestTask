package com.malushkoaa.feature_main.domain.usecases

import com.malushkoaa.feature_main.domain.repo.MainScreenRepo
import javax.inject.Inject

class GetCartItemsCountUseCase @Inject constructor(
    private val repo: MainScreenRepo
) {
    suspend operator fun invoke() = repo.getCartItemsCount()
}