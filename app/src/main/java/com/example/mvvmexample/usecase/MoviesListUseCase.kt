package com.example.mvvmexample.usecase

import com.example.mvvmexample.data.MoviesRepository

class MoviesListUseCase(private val moviesRepository: MoviesRepository) {
    operator fun invoke() = moviesRepository.getAllMoviesFromDataSource()
}