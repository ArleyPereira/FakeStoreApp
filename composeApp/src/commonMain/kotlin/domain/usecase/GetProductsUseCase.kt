package domain.usecase

import data.model.ProductResponse
import data.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(
    private val repository: HomeRepository
) {

    operator fun invoke(): Flow<List<ProductResponse>> {
        return repository.getProducts()
    }

}