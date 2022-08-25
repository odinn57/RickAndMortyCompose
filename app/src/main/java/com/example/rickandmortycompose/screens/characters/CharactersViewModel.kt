package com.example.rickandmortycompose.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortycompose.data.paging.CharactersDataSource

class CharactersViewModel : ViewModel() {

    val charactersPager = Pager(PagingConfig(pageSize = 1)) {
        CharactersDataSource()
    }.flow.cachedIn(viewModelScope)
}