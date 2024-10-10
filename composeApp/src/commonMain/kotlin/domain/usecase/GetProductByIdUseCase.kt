package domain.usecase

import data.model.ProductResponse
import domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetProductByIdUseCase(
    private val repository: HomeRepository
) {

    suspend operator fun invoke(productId: Int?): Flow<ProductResponse> {
        return repository.getProductById(productId)
    }

}