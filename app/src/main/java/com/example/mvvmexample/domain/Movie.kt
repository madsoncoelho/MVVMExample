package com.example.mvvmexample.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("titulo")
    val title: String,
    @SerializedName("descricao")
    val description: String?,
    @SerializedName("imagem")
    val image: String?,
    @SerializedName("data_lancamento")
    val releaseDate: String?
): Parcelable