package br.com.hellodev.fakestoreapp.data.database.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import br.com.hellodev.fakestoreapp.data.database.dao.CartDao
import br.com.hellodev.fakestoreapp.data.database.entity.ProductEntity
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = true
)
@ConstructedBy(StoreDatabaseConstructor::class)
@TypeConverters(BookTypeConverter::class)
abstract class StoreDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object StoreDatabaseConstructor : RoomDatabaseConstructor<StoreDatabase> {
    override fun initialize(): StoreDatabase
}

class BookTypeConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return Json.decodeFromString(
            ListSerializer(String.serializer()), value
        )
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return Json.encodeToString(
            ListSerializer(String.serializer()), list
        )
    }
}