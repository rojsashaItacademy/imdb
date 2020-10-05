package ru.trinitydigital.cinemainfo.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.trinitydigital.cinemainfo.data.model.CinemaSearchModel

interface ImdbService {

    @GET(".")
    fun getCinema(@Query("apikey") apiKey: String, @Query("s") title: String):
            Call<CinemaSearchModel>
}
