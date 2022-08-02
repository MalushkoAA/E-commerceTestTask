package com.malushkoaa.feature_my_cart.domain.usecases

import com.malushkoaa.feature_my_cart.domain.repo.CartRepo
import javax.inject.Inject

class GetCartDataUseCase @Inject constructor(
    private val repo:CartRepo
) {
    suspend operator fun invoke()=repo.getCartData()
}