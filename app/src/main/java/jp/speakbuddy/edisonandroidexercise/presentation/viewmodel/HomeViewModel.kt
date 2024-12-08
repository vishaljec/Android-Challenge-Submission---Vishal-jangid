package jp.speakbuddy.edisonandroidexercise.presentation.viewmodel

import CatFactEntity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.speakbuddy.edisonandroidexercise.domain.model.CatFact
import jp.speakbuddy.edisonandroidexercise.domain.usecase.GetSavedCatFactUseCase
import jp.speakbuddy.edisonandroidexercise.domain.usecase.FetchLatestCatFactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchLatestCatFactUseCase: FetchLatestCatFactUseCase,
    private val getSavedCatFactUseCase: GetSavedCatFactUseCase
) : ViewModel() {

    private val _catFact = MutableStateFlow<CatFact?>(null)
    val catFact: StateFlow<CatFact?> = _catFact

    fun getSavedCatFact() {
        viewModelScope.launch {
            _catFact.value = getSavedCatFactUseCase.invoke()
        }
    }

    // Fetch latest cat fact from remote API and update local DB
    fun fetchLatestCatFact() {
        viewModelScope.launch {
            val fetchedFact = fetchLatestCatFactUseCase()
            if (fetchedFact != null) {
                _catFact.value = fetchedFact
            } else {
                //  error = "Failed to fetch cat fact"
            }
        }
    }

}