package com.example.rickandmortycompose.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortycompose.data.paging.CharactersDataSource
import com.example.rickandmortycompose.data.room.CharactersDao
import com.example.rickandmortycompose.model.SingleCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersDataSource: CharactersDataSource,
    private val charactersDao: CharactersDao
) : ViewModel() {

    val charactersPager = Pager(PagingConfig(pageSize = 1)) {
        charactersDataSource
    }.flow.cachedIn(viewModelScope)

    fun addFavorite(character: SingleCharacter) {
        viewModelScope.launch(Dispatchers.IO) {
            charactersDao.insertSingleCharacter(character)
        }
    }

    fun deleteFavorite(character: SingleCharacter) {
        viewModelScope.launch(Dispatchers.IO) {
            charactersDao.deleteSingleCharacter(character)
        }
    }
}