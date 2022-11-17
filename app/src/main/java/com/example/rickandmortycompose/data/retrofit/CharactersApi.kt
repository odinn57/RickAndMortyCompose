package com.example.rickandmortycompose.data.retrofit

import com.example.rickandmortycompose.model.Characters
import com.example.rickandmortycompose.ui.components.Service
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET(Service.GET_CHARACTER)
    suspend fun getCharacters(@Query("page") page: Int): Characters
}