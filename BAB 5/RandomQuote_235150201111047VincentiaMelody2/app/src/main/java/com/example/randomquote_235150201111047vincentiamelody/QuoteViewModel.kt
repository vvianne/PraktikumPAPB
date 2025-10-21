package com.example.randomquote_235150201111047vincentiamelody

//class QuoteViewModel {
//}

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class QuoteViewModel : ViewModel() {
    private val repository = QuoteRepository()
    private val _quote = MutableStateFlow("Tap the button to get a quote")
    val quote: StateFlow<String>get() = _quote
    fun fetchQuote() {
        viewModelScope.launch {
            _quote.value = "Loading...";
            val result = repository.getRandomQuote()
            _quote.value = result
        }
    }
}