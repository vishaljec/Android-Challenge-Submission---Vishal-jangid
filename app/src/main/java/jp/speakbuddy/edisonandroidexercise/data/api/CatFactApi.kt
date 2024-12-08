package jp.speakbuddy.edisonandroidexercise.data.api

import retrofit2.Response
import retrofit2.http.GET

interface CatFactApi {
    @GET("facts/random")
    suspend fun getRandomCatFact(): Response<CatFactApiResponse>
}