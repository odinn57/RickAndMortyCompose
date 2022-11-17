package com.example.rickandmortycompose.data.room

import androidx.room.TypeConverter
import com.example.rickandmortycompose.model.Episode
import com.example.rickandmortycompose.model.Location
import com.example.rickandmortycompose.model.Origin
import com.google.gson.Gson
import java.io.Serializable

class DataConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun fromEpisodeToJSON(list: List<String>): String {
        val episode = Episode(list)
        return gson.toJson(episode)
    }


    @TypeConverter
    fun fromLocationToJSON(location: Location): String =
        gson.toJson(location)

    @TypeConverter
    fun fromOriginToJSON(origin: Origin): String =
        gson.toJson(origin)

    @TypeConverter
    fun fromJSONToEpisode(json: String): List<String> {
        val episode = gson.fromJson(json, Episode::class.java)
        return episode.episode
    }

    @TypeConverter
    fun fromJSONToLocation(json: String): Location =
        gson.fromJson(json, Location::class.java)

    @TypeConverter
    fun fromJSONToOrigin(json: String): Origin =
        gson.fromJson(json, Origin::class.java)
}