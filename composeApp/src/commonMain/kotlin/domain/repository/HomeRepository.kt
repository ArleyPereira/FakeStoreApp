package domain.repository

import data.model.ProductResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getProducts(): Flow<List<ProductResponse>>

}