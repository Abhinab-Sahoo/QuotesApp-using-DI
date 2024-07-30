package com.example.apiusingdi.data.model

import com.example.apiusingdi.domain.model.Quote

data class QuoteResponse(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)