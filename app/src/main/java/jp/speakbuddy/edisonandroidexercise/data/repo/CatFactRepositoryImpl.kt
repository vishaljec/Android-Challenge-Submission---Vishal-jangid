package jp.speakbuddy.edisonandroidexercise.data.repo

import CatFactEntity
import jp.speakbuddy.edisonandroidexercise.data.local.CatFactDao
import jp.speakbuddy.edisonandroidexercise.domain.repo.CatFactRepository
import javax.inject.Inject

class CatFactRepositoryImpl @Inject constructor(
    private val dao: CatFactDao
) : CatFactRepository {
    override suspend fun saveCatFact(fact: String, length: Int) {
        dao.insertCatFact(CatFactEntity(fact = fact, length = length))
    }

    override suspend fun getSavedCatFact(): CatFactEntity? {
        return dao.getLatestCatFact()
    }
}