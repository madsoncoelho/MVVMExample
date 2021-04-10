package com.example.mvvmexample.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String?,
    val image: String?,
    val releaseDate: String?
)