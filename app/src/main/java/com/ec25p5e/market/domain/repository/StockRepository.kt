package com.ec25p5e.market.domain.repository

import com.ec25p5e.market.domain.model.CompanyInfo
import com.ec25p5e.market.domain.model.CompanyListing
import com.ec25p5e.market.domain.model.IntradayInfo
import com.ec25p5e.market.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}