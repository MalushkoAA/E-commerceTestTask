package com.malushkoaa.feature_details.domain.usecases

import com.malushkoaa.feature_details.domain.repo.DetailsRepo
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val repo: DetailsRepo
) {
    suspend operator fun invoke() = repo.getProductDetails()
}