package com.example.rickandmortycompose.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.rickandmortycompose.ui.components.APP_THEME_KEY
import com.example.rickandmortycompose.ui.theme.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreTheme(private val context: Context) {
    val getTheme: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[THEME_KEY] ?: Theme.Light.name
        }

    suspend fun saveTheme(theme: String) {
        context.dataStore.edit { preferences ->
            preferences[THEME_KEY] = theme
        }
    }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(APP_THEME_KEY)
        val THEME_KEY = stringPreferencesKey(APP_THEME_KEY)
    }
}