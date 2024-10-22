package br.com.hellodev.fakestoreapp.data.mapper

import br.com.hellodev.fakestoreapp.data.model.ProductColorResponse
import br.com.hellodev.fakestoreapp.data.model.ProductResponse
import br.com.hellodev.fakestoreapp.data.model.RatingResponse
import br.com.hellodev.fakestoreapp.data.model.SizeProductResponse
import br.com.hellodev.fakestoreapp.domain.model.Product
import br.com.hellodev.fakestoreapp.domain.model.ProductColor
import br.com.hellodev.fakestoreapp.domain.model.Rating
import br.com.hellodev.fakestoreapp.domain.model.SizeProduct

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