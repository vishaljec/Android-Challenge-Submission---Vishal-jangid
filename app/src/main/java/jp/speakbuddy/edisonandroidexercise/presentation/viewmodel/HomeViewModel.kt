package jp.speakbuddy.edisonandroidexercise.presentation.viewmodel

import CatFactEntity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.speakbuddy.edisonandroidexercise.domain.usecase.GetSavedCatFactUseCase
import jp.speakbuddy.edisonandroidexercise.domain.usecase.SaveCatFactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val saveCatFactUseCase: SaveCatFactUseCase,
    private val getSavedCatFactUseCase: GetSavedCatFactUseCase
) : ViewModel() {

    private val _catFact = MutableStateFlow<CatFactEntity?>(null)
    val catFact: StateFlow<CatFactEntity?> = _catFact

    fun saveCatFact(fact: String, length: Int) {
        viewModelScope.launch {
            saveCatFactUseCase(fact, length)
        }
    }

    fun loadCatFact() {
        viewModelScope.launch {
            _catFact.value = getSavedCatFactUseCase()
        }
    }
}