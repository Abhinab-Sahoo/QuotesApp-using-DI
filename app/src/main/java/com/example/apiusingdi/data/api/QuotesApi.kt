package com.example.apiusingdi.data.api

import com.example.apiusingdi.data.model.QuoteResponse
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes(): QuoteResponse

//    if i add a comment here how would i push it to github
}