package suyun.personal.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface Api {
    @GET("weather?q=London")
    suspend fun weather(@Header("x-rapidapi-key") token: String) : Response<Weathers>
}