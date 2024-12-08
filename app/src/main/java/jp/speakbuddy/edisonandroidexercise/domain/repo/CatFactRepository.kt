package jp.speakbuddy.edisonandroidexercise.domain.repo

import CatFactEntity

interface CatFactRepository {
    suspend fun saveCatFact(fact: String, length: Int)
    suspend fun getSavedCatFact(): CatFactEntity?
}