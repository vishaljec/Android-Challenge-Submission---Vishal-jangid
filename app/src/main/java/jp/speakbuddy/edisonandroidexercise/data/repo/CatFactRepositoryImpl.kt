package jp.speakbuddy.edisonandroidexercise.data.repo

import CatFactEntity
import jp.speakbuddy.edisonandroidexercise.data.api.CatFactApi
import jp.speakbuddy.edisonandroidexercise.data.local.CatFactDao
import jp.speakbuddy.edisonandroidexercise.domain.model.CatFact
import jp.speakbuddy.edisonandroidexercise.domain.repo.CatFactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatFactRepositoryImpl(
    private val catFactApi: CatFactApi, private val catFactDao: CatFactDao
) : CatFactRepository {

    override suspend fun getSavedCatFact(): CatFact? {
        return withContext(Dispatchers.IO) {
            val catFactEntity = catFactDao.getCatFact()
            catFactEntity?.let { CatFact(it.fact, it.length) }
        }
    }

    override suspend fun fetchLatestCatFact(): CatFact? {
        return withContext(Dispatchers.IO) {
            val response = catFactApi.getRandomCatFact()
            if (response.isSuccessful) {
                response.body()?.let {
                    val catFact = CatFact(it.fact, it.length)
                    // Save the new cat fact to local database
                    catFactDao.insertCatFact(
                        CatFactEntity(
                            fact = catFact.fact, length = catFact.length
                        )
                    )
                    return@withContext catFact
                }
            }
            null
        }
    }
}