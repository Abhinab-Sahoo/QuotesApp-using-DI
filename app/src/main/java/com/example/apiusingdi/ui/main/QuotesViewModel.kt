package com.example.apiusingdi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiusingdi.data.repository.QuotesRepository
import com.example.apiusingdi.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuotesViewModel @Inject constructor(private val repository: QuotesRepository) : ViewModel() {

    private val _quotes = MutableLiveData<List<Quote>>()
    val quotes: LiveData<List<Quote>> = _quotes

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchQuotes() {
        viewModelScope.launch {
            try {
                _quotes.value = repository.getQuotes()
            } catch (e: Exception) {
                _error.value = "Error fetching quotes: ${e.message}"
            }
        }
    }
}