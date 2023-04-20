package com.example.horoscopapp.domain

import com.example.horoscopapp.data.network.HoroscopeApi
import com.example.horoscopapp.data.network.model.HoroscopeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetHoroscopeUseCase @Inject constructor(private val api:HoroscopeApi){

    //metodo invoke llama al metodo suscribete()
    suspend operator fun invoke(): Flow<HoroscopeResponse?> {
        val response = api.getHoroscope("capricorn","today")
        if (response.isSuccessful){
            return flowOf(response.body())
        }
        return flowOf(null)
    }

}