package br.com.hellodev.fakestoreapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val title: String?,
    val image: String?,
    val price: Double?
)