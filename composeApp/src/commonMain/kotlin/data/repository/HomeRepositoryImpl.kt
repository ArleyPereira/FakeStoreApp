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
        return try {
            val response = httpClient.get("https://fakestoreapi.com/products")
            val responseBody: String = products()//response.bodyAsText()
            val products = Json.decodeFromString<List<ProductResponse>>(responseBody)
            flow { emit(products) }
        } catch (exception: Exception) {
            throw exception
        }
    }

}

private fun products(): String {
    return "[\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Este tênis é muito bom\",\n" +
            "      \"id\": 1,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/02518351.jpg\",\n" +
            "      \"price\": 499.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 3,\n" +
            "         \"rate\": 4.99\n" +
            "      },\n" +
            "      \"title\": \"Tênis Nike Zoom Bella 6 Feminino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Outro tênis incrível\",\n" +
            "      \"id\": 2,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/01356551.jpg\",\n" +
            "      \"price\": 399.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 5,\n" +
            "         \"rate\": 4.75\n" +
            "      },\n" +
            "      \"title\": \"Tênis Adidas Boost Masculino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Ótima escolha para corridas\",\n" +
            "      \"id\": 3,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/025803ID.jpg\",\n" +
            "      \"price\": 299.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 2,\n" +
            "         \"rate\": 4.5\n" +
            "      },\n" +
            "      \"title\": \"Tênis Puma Speed 500 Feminino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Conforto e estilo em um só tênis\",\n" +
            "      \"id\": 4,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/02580315.jpg\",\n" +
            "      \"price\": 549.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 4,\n" +
            "         \"rate\": 4.85\n" +
            "      },\n" +
            "      \"title\": \"Tênis Asics Gel Nimbus 23 Masculino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Este tênis é muito bom\",\n" +
            "      \"id\": 5,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/0258035A.jpg\",\n" +
            "      \"price\": 499.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 3,\n" +
            "         \"rate\": 4.99\n" +
            "      },\n" +
            "      \"title\": \"Tênis Nike Zoom Bella 6 Feminino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Outro tênis incrível\",\n" +
            "      \"id\": 6,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/025803P1.jpg\",\n" +
            "      \"price\": 399.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 5,\n" +
            "         \"rate\": 4.75\n" +
            "      },\n" +
            "      \"title\": \"Tênis Adidas Boost Masculino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Ótima escolha para corridas\",\n" +
            "      \"id\": 7,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/0228105C.jpg\",\n" +
            "      \"price\": 299.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 2,\n" +
            "         \"rate\": 4.5\n" +
            "      },\n" +
            "      \"title\": \"Tênis Puma Speed 500 Feminino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Conforto e estilo em um só tênis\",\n" +
            "      \"id\": 8,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/022810A1.jpg\",\n" +
            "      \"price\": 549.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 4,\n" +
            "         \"rate\": 4.85\n" +
            "      },\n" +
            "      \"title\": \"Tênis Asics Gel Nimbus 23 Masculino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Ótima escolha para corridas\",\n" +
            "      \"id\": 9,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/02281086.jpg\",\n" +
            "      \"price\": 299.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 2,\n" +
            "         \"rate\": 4.5\n" +
            "      },\n" +
            "      \"title\": \"Tênis Puma Speed 500 Feminino\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"category\": \"Tenis\",\n" +
            "      \"description\": \"Conforto e estilo em um só tênis\",\n" +
            "      \"id\": 10,\n" +
            "      \"image\": \"https://imgnike-a.akamaihd.net/768x768/02281087.jpg\",\n" +
            "      \"price\": 549.99,\n" +
            "      \"rating\": {\n" +
            "         \"count\": 4,\n" +
            "         \"rate\": 4.85\n" +
            "      },\n" +
            "      \"title\": \"Tênis Asics Gel Nimbus 23 Masculino\"\n" +
            "   }\n" +
            "]"
}