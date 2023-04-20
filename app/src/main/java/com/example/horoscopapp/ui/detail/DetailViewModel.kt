package com.example.horoscopapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscopapp.domain.GetHoroscopeUseCase
import com.example.horoscopapp.ui.detail.model.DetailUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getHoroscopeUseCase: GetHoroscopeUseCase): ViewModel(){
    //Estado de pantalla
    private val _uiState = MutableStateFlow<DetailUIState>(DetailUIState.Loading) //ESTADO REAL DE LA ACTIVITY y solo el viewmodel lo puede modificar
    val uiState:StateFlow<DetailUIState> = _uiState //usuario va leer este estado, asi puede leerlo pero no escribirlo
    fun getHoroscope(){
        viewModelScope.launch {
            //llama al metodo invoke del GetHoroscopeUseCase
            getHoroscopeUseCase().collect{horoscope ->
                //cada vez que haya un cambio en el flow, se colectea
                if (horoscope!=null){
                    _uiState.value = DetailUIState.Success(horoscope)
                }
            }
        }

    }



}