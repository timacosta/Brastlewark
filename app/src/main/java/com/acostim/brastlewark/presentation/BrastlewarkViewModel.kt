package com.acostim.brastlewark.presentation


import android.util.Log
import androidx.lifecycle.*
import com.acostim.brastlewark.core.Resource
import com.acostim.brastlewark.domain.BrastlewarkRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class BrastlewarkViewModel
@Inject
constructor(
    private val repository: BrastlewarkRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val currentGnomeName = savedStateHandle.getLiveData<String>("gnomeName", "")

    fun setGnome(gnomeName: String) {
        currentGnomeName.value = gnomeName
    }

    val fetchGnomeList = currentGnomeName.distinctUntilChanged().switchMap { gnomeName ->
        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(Resource.Loading)
            try {
                repository.getAllGnomes().collect {
                    emit(it)
                    Log.d("fetchGnomeList: ", "$it")
                }
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

}