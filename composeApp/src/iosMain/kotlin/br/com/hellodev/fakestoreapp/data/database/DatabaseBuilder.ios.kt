package br.com.hellodev.fakestoreapp.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.hellodev.fakestoreapp.data.database.db.StoreDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

fun getDatabaseBuilder(): RoomDatabase.Builder<StoreDatabase> {
    val dbFile = documentDirectory() + "/book.db"
    return Room.databaseBuilder(name = dbFile)
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}