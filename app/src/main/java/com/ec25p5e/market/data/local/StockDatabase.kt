package com.ec25p5e.market.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CompanyListingEntity::class],
    version = 1,
    exportSchema = false
)
abstract class StockDatabase: RoomDatabase() {
    abstract val dao: StockDao
}