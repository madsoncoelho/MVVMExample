package com.example.mvvmexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.model.Movie

class MoviesListViewModel: ViewModel() {
    private val moviesList = arrayListOf(
        Movie(0, "Titanic", null, null, null),
        Movie(1, "Central do Brasil", null, null, null)
    )
    private var _ldMoviesList = MutableLiveData<List<Movie>>()
    val ldMoviesList: LiveData<List<Movie>>
    get() = _ldMoviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        _ldMoviesList.value = moviesList
    }

}