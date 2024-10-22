package br.com.hellodev.fakestoreapp.domain.usecase

import br.com.hellodev.fakestoreapp.data.model.ProductResponse
import br.com.hellodev.fakestoreapp.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(
    private val repository: HomeRepository
) {

    suspend operator fun invoke(): Flow<List<ProductResponse>> {
        return repository.getProducts()
    }

}