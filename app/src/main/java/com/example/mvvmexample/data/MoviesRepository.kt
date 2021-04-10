package com.example.mvvmexample.data

class MoviesRepository(private val moviesDataSource: MoviesDataSource) {
    fun getAllMoviesFromDataSource() = moviesDataSource.getAllMovies()
}