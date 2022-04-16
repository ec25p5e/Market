package com.ec25p5e.market.data.repsository

import com.ec25p5e.market.data.local.StockDatabase
import com.ec25p5e.market.data.mapper.toCompanyListing
import com.ec25p5e.market.data.remote.dto.StockApi
import com.ec25p5e.market.domain.model.CompanyListing
import com.ec25p5e.market.domain.repository.StockRepository
import com.ec25p5e.market.util.Resource
import com.opencsv.CSVReader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: StockApi,
    val db: StockDatabase
): StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if(shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try {
                val response = api.getListings()
            } catch(e: IOException) {
                e.printStackTrace();
                emit(Resource.Error("Couldn't load data"))
            } catch(e: HttpException) {
                e.printStackTrace();
                emit(Resource.Error("Couldn't load data"))
            }
        }
    }
}