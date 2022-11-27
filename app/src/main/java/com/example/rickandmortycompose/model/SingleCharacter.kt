package com.example.rickandmortycompose.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmortycompose.ui.components.DatabaseKeys
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize
@Entity(tableName = DatabaseKeys.CHARACTERS_TABLE)
data class SingleCharacter(
    val created: String = "",
    val episode: List<String> = listOf(),
    val gender: String = "",
    @PrimaryKey(autoGenerate = false)
    @NotNull
    val id: Int = 0,
    val image: String = "",
    val location: Location = Location(),
    val name: String = "",
    val origin: Origin = Origin(),
    val species: String = "",
    val status: String = "",
    val type: String = "",
    val url: String = "",
    val isFavorite: Boolean = false
) : Parcelable

