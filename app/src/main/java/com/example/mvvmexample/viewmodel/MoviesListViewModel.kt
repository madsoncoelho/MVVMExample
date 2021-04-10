package com.example.mvvmexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.api.MoviesRestApiTask
import com.example.mvvmexample.model.Movie
import com.example.mvvmexample.repository.MoviesRepository

class MoviesListViewModel: ViewModel() {

    companion object {
        const val TAG = "MoviesListViewModel"
    }
    private val moviesRestApiTask = MoviesRestApiTask()
    private val moviesRepository = MoviesRepository(moviesRestApiTask)

    private var _ldMoviesList = MutableLiveData<List<Movie>>()
    val ldMoviesList: LiveData<List<Movie>>
    get() = _ldMoviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _ldMoviesList.postValue(moviesRepository.getAllMovies())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }

}