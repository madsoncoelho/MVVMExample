package com.example.mvvmexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.api.MoviesRestApiTask
import com.example.mvvmexample.data.MoviesRepository
import com.example.mvvmexample.domain.Movie
import com.example.mvvmexample.implementations.MoviesDataSourceImplementation
import com.example.mvvmexample.usecase.MoviesListUseCase

class MoviesListViewModel: ViewModel() {

    companion object {
        const val TAG = "MoviesListViewModel"
    }
    private val moviesRestApiTask = MoviesRestApiTask()
    private val moviesDataSource = MoviesDataSourceImplementation(moviesRestApiTask)
    private val moviesRepository = MoviesRepository(moviesDataSource)
    private val moviesListUseCase = MoviesListUseCase(moviesRepository)

    private var _ldMoviesList = MutableLiveData<List<Movie>>()
    val ldMoviesList: LiveData<List<Movie>>
    get() = _ldMoviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _ldMoviesList.postValue(moviesListUseCase.invoke())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }

}