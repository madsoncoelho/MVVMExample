package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.model.Movie
import com.example.mvvmexample.viewmodel.MoviesListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var moviesListViewModel: MoviesListViewModel

    private lateinit var rvMoviesList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMoviesList = findViewById(R.id.rvMoviesList)
        moviesListViewModel = ViewModelProvider.NewInstanceFactory().create(MoviesListViewModel::class.java)
        moviesListViewModel.init()
        initObserver()
    }

    private fun initObserver() {
        moviesListViewModel.ldMoviesList.observe(this, Observer { list ->
            populateList(list)
        })
    }

    private fun populateList(list: List<Movie>) {
        rvMoviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }
}