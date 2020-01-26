package lk.sliit.movieapp.ui

import android.telecom.Call
import lk.sliit.movieapp.model.Movie
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovieList(): retrofit2.Call<MutableList<Movie>>
}