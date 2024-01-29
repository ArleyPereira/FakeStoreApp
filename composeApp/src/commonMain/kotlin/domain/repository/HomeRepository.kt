package domain.repository

import data.model.ProductResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getProducts(): Flow<List<ProductResponse>>

    suspend fun getProductById(productId: Int?): Flow<ProductResponse>

}