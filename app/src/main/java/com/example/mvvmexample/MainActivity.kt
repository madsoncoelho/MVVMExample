package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.model.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var rvMoviesList: RecyclerView
    private val moviesList = arrayListOf(
            Movie(0, "Titanic", null, null, null),
            Movie(1, "Central do Brasil", null, null, null)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMoviesList = findViewById(R.id.rvMoviesList)
        populateList()
    }

    private fun populateList() {
        rvMoviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(moviesList)
        }
    }
}