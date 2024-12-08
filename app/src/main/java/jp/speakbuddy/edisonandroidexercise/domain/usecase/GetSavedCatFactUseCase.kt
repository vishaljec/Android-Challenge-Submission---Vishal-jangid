package jp.speakbuddy.edisonandroidexercise.domain.usecase

import CatFactEntity
import jp.speakbuddy.edisonandroidexercise.domain.repo.CatFactRepository
import javax.inject.Inject

class GetSavedCatFactUseCase @Inject constructor(
    private val repository: CatFactRepository
) {
    suspend operator fun invoke(): CatFactEntity? {
        return repository.getSavedCatFact()
    }
}