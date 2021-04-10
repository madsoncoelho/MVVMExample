package com.example.mvvmexample.api

import com.example.mvvmexample.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>
}