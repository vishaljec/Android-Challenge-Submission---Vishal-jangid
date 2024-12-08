package jp.speakbuddy.edisonandroidexercise.domain.repo

import jp.speakbuddy.edisonandroidexercise.domain.model.CatFact

interface CatFactRepository {
    suspend fun getSavedCatFact(): CatFact?
    suspend fun fetchLatestCatFact(): CatFact?
}