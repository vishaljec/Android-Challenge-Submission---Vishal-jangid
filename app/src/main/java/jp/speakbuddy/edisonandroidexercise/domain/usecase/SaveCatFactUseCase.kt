package jp.speakbuddy.edisonandroidexercise.domain.usecase

import jp.speakbuddy.edisonandroidexercise.domain.repo.CatFactRepository
import javax.inject.Inject

class SaveCatFactUseCase @Inject constructor(
    private val repository: CatFactRepository
) {
    suspend operator fun invoke(fact: String, length: Int) {
        repository.saveCatFact(fact, length)
    }
}