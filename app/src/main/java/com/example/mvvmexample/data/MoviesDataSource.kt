package com.example.mvvmexample.data

import com.example.mvvmexample.domain.Movie

interface MoviesDataSource {

    fun getAllMovies(): List<Movie>
}