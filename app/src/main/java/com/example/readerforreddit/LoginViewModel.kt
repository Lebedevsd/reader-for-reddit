package com.example.readerforreddit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel(){
    init {
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.


        }
    }
}