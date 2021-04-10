package com.example.mvvmexample.repository

import android.util.Log
import com.example.mvvmexample.api.MoviesRestApiTask
import com.example.mvvmexample.model.Movie

class MoviesRepository(private val moviesRestApiTask: MoviesRestApiTask) {

    companion object {
        const val TAG = "MoviesRepository"
    }
    private val moviesList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie> {
        val request = moviesRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let { list ->
                moviesList.addAll(list)
            }
        } else {
            request.errorBody()?.let { responseBody ->
                Log.d(TAG, responseBody.toString())
            }
        }

        return moviesList
    }
}