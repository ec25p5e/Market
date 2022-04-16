package com.ec25p5e.market.di

import com.ec25p5e.market.data.csv.CSVParser
import com.ec25p5e.market.data.csv.CompanyListingsParser
import com.ec25p5e.market.data.csv.IntradayInfoParser
import com.ec25p5e.market.data.repsository.StockRepositoryImpl
import com.ec25p5e.market.domain.model.CompanyInfo
import com.ec25p5e.market.domain.model.CompanyListing
import com.ec25p5e.market.domain.model.IntradayInfo
import com.ec25p5e.market.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}