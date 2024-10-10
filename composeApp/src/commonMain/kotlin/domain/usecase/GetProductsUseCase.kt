package domain.usecase

import data.model.ProductResponse
import domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(
    private val repository: HomeRepository
) {

    suspend operator fun invoke(): Flow<List<ProductResponse>> {
        return repository.getProducts()
    }

}