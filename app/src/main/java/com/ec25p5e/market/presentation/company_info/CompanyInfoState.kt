package com.ec25p5e.market.presentation.company_info

import com.ec25p5e.market.domain.model.CompanyInfo
import com.ec25p5e.market.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
