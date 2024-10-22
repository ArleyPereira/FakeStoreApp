package br.com.hellodev.fakestoreapp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.hellodev.fakestoreapp.data.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Upsert
    suspend fun upsertProduct(entity: ProductEntity)

    @Transaction
    @Query("SELECT * FROM cart WHERE id = :id")
    suspend fun getProductById(id: Int): ProductEntity

    @Transaction
    @Query("SELECT * FROM cart WHERE id = :id")
    fun getProductByIdFlow(id: Int): Flow<ProductEntity?>

    @Transaction
    @Query("SELECT * FROM cart")
    fun readAllProducts(): Flow<List<ProductEntity>>

    @Transaction
    @Query("DELETE FROM cart WHERE id = :id")
    suspend fun deleteProductById(id: Int)
}