package com.example.apiusingdi.data.repository

import com.example.apiusingdi.data.api.QuotesApi
import com.example.apiusingdi.domain.model.Quote
import javax.inject.Inject

class QuotesRepository @Inject constructor(private val api: QuotesApi) {
    suspend fun getQuotes(): List<Quote> {
        return api.getQuotes().quotes
    }
}