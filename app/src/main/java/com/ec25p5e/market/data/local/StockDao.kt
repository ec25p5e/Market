package com.ec25p5e.market.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ec25p5e.market.domain.model.CompanyListing

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyListings(
        companyListingEntity: List<CompanyListingEntity>
    )

    @Query("delete from companylistingentity")
    suspend fun clearCompanyListings()

    @Query(
        """
        select  *
        from    companylistingentity
        where   lower(name) like '%' || lower(:query) || '%'
        or      upper(:query) == symbol
        """
    )
    suspend fun searchCompanyListing(query: String): List<CompanyListing>
}