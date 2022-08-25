package com.example.rickandmortycompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortycompose.data.retrofit.ApiService
import com.example.rickandmortycompose.model.Result
import com.example.rickandmortycompose.model.Result.Companion.toSingleCharacters
import com.example.rickandmortycompose.model.SingleCharacter

class CharactersDataSource : PagingSource<Int, SingleCharacter>() {
    override fun getRefreshKey(state: PagingState<Int, SingleCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SingleCharacter> {
        return try {
            val apiService = ApiService.getInstance()
            val nextPageNumber = params.key ?: 1
            val response = apiService.getCharacters(nextPageNumber)
            LoadResult.Page(
                data = response.results.map { it.toSingleCharacters() },
                prevKey = if (nextPageNumber == 1) null else nextPageNumber,
                nextKey = if (response.info.next != "") nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}