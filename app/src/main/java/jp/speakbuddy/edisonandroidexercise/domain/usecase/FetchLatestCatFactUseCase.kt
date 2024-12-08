package jp.speakbuddy.edisonandroidexercise.domain.usecase

import jp.speakbuddy.edisonandroidexercise.domain.model.CatFact
import jp.speakbuddy.edisonandroidexercise.domain.repo.CatFactRepository
import javax.inject.Inject

class FetchLatestCatFactUseCase @Inject constructor(private val repository: CatFactRepository) {
    suspend operator fun invoke(): CatFact? {
        return repository.fetchLatestCatFact()
    }
}