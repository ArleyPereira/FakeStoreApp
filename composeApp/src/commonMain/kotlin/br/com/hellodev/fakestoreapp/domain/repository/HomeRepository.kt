package br.com.hellodev.fakestoreapp.domain.repository

import br.com.hellodev.fakestoreapp.data.model.ProductResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getProducts(): Flow<List<ProductResponse>>

    suspend fun getProductById(productId: Int?): Flow<ProductResponse>

}