package com.example.rickandmortycompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.room.withTransaction
import com.example.rickandmortycompose.data.retrofit.CharactersApi
import com.example.rickandmortycompose.data.room.CharactersDao
import com.example.rickandmortycompose.data.room.RoomDatabase
import com.example.rickandmortycompose.model.Result.Companion.toSingleCharacters
import com.example.rickandmortycompose.model.SingleCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersDataSource @Inject constructor(
    private val charactersApi: CharactersApi,
    private val charactersDao: CharactersDao
) : PagingSource<Int, SingleCharacter>() {

    override fun getRefreshKey(state: PagingState<Int, SingleCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SingleCharacter> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = charactersApi.getCharacters(nextPageNumber)
            val favorite = charactersDao.getFavoritesCharacters()
            LoadResult.Page(
                data = response.results.map {
                    it.toSingleCharacters(
                        isFavorite = favorite.any { value -> value.id == it.id }
                    )
                },
                prevKey = if (nextPageNumber == 1) null else nextPageNumber,
                nextKey = if (response.info.next != "") nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}