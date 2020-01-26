package lk.sliit.movieapp.common

import lk.sliit.movieapp.retrofit.RetrofitClient
import lk.sliit.movieapp.ui.RetrofitService
import retrofit2.create

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"

    val retrofitService: RetrofitService
    get() =  RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)


}