package ru.trinitydigital.cinemainfo.data.model

import com.google.gson.annotations.SerializedName

data class CinemaSearchItemModel(
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    val imdbID: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Poster", alternate = ["poster"])
    val poster: String,
)