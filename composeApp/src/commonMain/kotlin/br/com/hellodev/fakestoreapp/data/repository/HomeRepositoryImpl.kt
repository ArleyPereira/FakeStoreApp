package br.com.hellodev.fakestoreapp.data.repository

import br.com.hellodev.fakestoreapp.data.model.ProductResponse
import br.com.hellodev.fakestoreapp.domain.repository.HomeRepository
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
            val responseBody: String = response.bodyAsText()
            val products = Json.decodeFromString<List<ProductResponse>>(responseBody)
            flow { emit(products) }
        } catch (exception: Exception) {
            throw exception
        }
    }

    override suspend fun getProductById(productId: Int?): Flow<ProductResponse> {
        return try {
            //val response = httpClient.get("https://fakestoreapi.com/products/${productId}")
            val responseBody: String = product()//response.bodyAsText()
            val product = Json.decodeFromString<ProductResponse>(responseBody)
            flow { emit(product) }
        } catch (exception: Exception) {
            throw exception
        }
    }

}

private fun products(): String {
    return "[\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 1,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/02518351.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Air Max Alpha Trainer 5 Masculino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 2,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/025803ID.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Metcon 9 Masculino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 3,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/02580315.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Zoom Fly 5 Masculino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 4,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/0258035A.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Air Max Alpha Trainer 5 Masculino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 5,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/025803P1.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Pegasus 40 Masculino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 6,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/0228105C.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Dunk Low Panda Feminino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 7,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/022810A1.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Air Zoom Alphafly NEXT% 2 Masculino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 8,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/02281086.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Pegasus 40 Masculino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"category\": \"Tenis\",\n" +
            "    \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "    \"id\": 9,\n" +
            "    \"image\": \"https://imgnike-a.akamaihd.net/768x768/02281087.jpg\",\n" +
            "    \"price\": 499.99,\n" +
            "    \"rating\": {\n" +
            "      \"count\": 3,\n" +
            "      \"rate\": 4.99\n" +
            "    },\n" +
            "    \"title\": \"Tênis Nike Metcon 9 Flyease Masculino\",\n" +
            "    \"colors\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"color\": \"#FF0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"color\": \"#0000FF\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"color\": \"#00FF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"color\": \"#FFFF00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"color\": \"#800080\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]"
}

private fun product(): String {
    return "{\n" +
            "  \"category\": \"Tenis\",\n" +
            "  \"description\": \"Este tênis é muito bom. Oferece conforto excepcional e suporte para seus pés durante atividades esportivas. Além disso, possui um design moderno que combina estilo e funcionalidade.\",\n" +
            "  \"id\": 1,\n" +
            "  \"image\": \"https://imgnike-a.akamaihd.net/768x768/02518351.jpg\",\n" +
            "  \"price\": 499.99,\n" +
            "  \"rating\": {\n" +
            "    \"count\": 3,\n" +
            "    \"rate\": 4.99\n" +
            "  },\n" +
            "  \"title\": \"Tênis Nike Zoom Bella 6 Feminino\",\n" +
            "  \"colors\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"color\": \"#FF0000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2,\n" +
            "      \"color\": \"#0000FF\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4,\n" +
            "      \"color\": \"#00FF00\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 5,\n" +
            "      \"color\": \"#FFFF00\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 6,\n" +
            "      \"color\": \"#800080\"\n" +
            "    }\n" +
            "  ]\n" +
            "}\n"
}