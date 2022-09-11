package com.example.rickandmortycompose.model

data class Characters(
    val info: Info = Info(),
    val results: List<Result> = listOf()
)