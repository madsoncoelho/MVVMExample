package com.example.mvvmexample.implementations

import android.util.Log
import com.example.mvvmexample.api.MoviesRestApiTask
import com.example.mvvmexample.data.MoviesDataSource
import com.example.mvvmexample.domain.Movie

class MoviesDataSourceImplementation(
    private val moviesRestApiTask: MoviesRestApiTask): MoviesDataSource {

    companion object {
        const val TAG = "MoviesDataSourceImplementation"
    }
    private val moviesList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
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