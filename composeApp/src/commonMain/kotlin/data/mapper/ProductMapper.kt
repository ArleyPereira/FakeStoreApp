package data.mapper

import data.model.ProductColorResponse
import data.model.ProductResponse
import data.model.RatingResponse
import data.model.SizeProductResponse
import domain.model.Product
import domain.model.ProductColor
import domain.model.Rating
import domain.model.SizeProduct

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
        title = title,
        colors = colors?.map { it.toDomain() }
    )
}

fun SizeProductResponse.toDomain(): SizeProduct {
    return SizeProduct(
        id = id,
        name = name
    )
}

fun ProductColorResponse.toDomain(): ProductColor {
    return ProductColor(
        id = id,
        color = color
    )
}