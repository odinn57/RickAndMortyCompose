package com.example.rickandmortycompose.data.retrofit

import com.example.rickandmortycompose.model.Characters
import com.example.rickandmortycompose.ui.components.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Service.GET_CHARACTER)
    suspend fun getCharacters(@Query("page") page: Int): Characters

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(Service.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

}