package data.mapper

import data.model.ProductResponse
import data.model.RatingResponse
import domain.model.Product
import domain.model.Rating

fun RatingResponse.toDomain(): Rating {
    return Rating(
        count = count,
        rate = rate
    )
}

fun ProductResponse.toDomain(): Product {
    return Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        ratingResponse = ratingResponse?.toDomain(),
        title = title
    )
}