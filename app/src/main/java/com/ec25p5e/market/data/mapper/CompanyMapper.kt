package com.ec25p5e.market.data.mapper

import com.ec25p5e.market.data.local.CompanyListingEntity
import com.ec25p5e.market.data.remote.dto.CompanyInfoDto
import com.ec25p5e.market.domain.model.CompanyInfo
import com.ec25p5e.market.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}