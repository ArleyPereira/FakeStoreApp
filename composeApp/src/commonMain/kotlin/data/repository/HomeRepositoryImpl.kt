package data.repository

import data.model.ProductResponse
import domain.repository.HomeRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class HomeRepositoryImpl(
    private val httpClient: HttpClient
) : HomeRepository {

    override suspend fun getProducts(): Flow<List<ProductResponse>> {
        try {
            val response = httpClient.get("https://fakestoreapi.com/products")
            val responseBody: String = response.bodyAsText()
            val products = Json.decodeFromString<List<ProductResponse>>(responseBody)
            return flow {
                emit(products)
            }
        } catch (exception: Exception) {
            throw exception
        }
    }

}