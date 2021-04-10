package com.example.mvvmexample.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.R
import com.example.mvvmexample.domain.Movie
import com.example.mvvmexample.viewmodel.MoviesListViewModel
import kotlinx.android.synthetic.main.activity_main.*

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
        loadingVisibility(true)
    }

    private fun initObserver() {
        moviesListViewModel.ldMoviesList.observe(this, Observer { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        rvMoviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}