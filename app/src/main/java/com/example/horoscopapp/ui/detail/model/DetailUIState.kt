package com.example.horoscopapp.ui.detail.model

import com.example.horoscopapp.data.network.model.HoroscopeResponse

//clase sellada
sealed class DetailUIState {
    object Loading: DetailUIState()
    data class Success(val horoscopeResponse: HoroscopeResponse) :DetailUIState()
    data class Error(val msg: String): DetailUIState()
}