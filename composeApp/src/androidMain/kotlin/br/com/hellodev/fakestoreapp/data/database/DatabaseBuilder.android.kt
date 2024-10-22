package br.com.hellodev.fakestoreapp.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.hellodev.fakestoreapp.data.database.db.StoreDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<StoreDatabase> {
    val dbFile = context.getDatabasePath("book.db")
    return Room.databaseBuilder(
        context = context,
        name = dbFile.absolutePath
    )
}