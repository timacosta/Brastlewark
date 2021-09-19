package com.acostim.brastlewark.presentation


import androidx.lifecycle.*
import com.acostim.brastlewark.core.Resource
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.domain.BrastlewarkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BrastlewarkViewModel
@Inject
constructor(
    private val repository: BrastlewarkRepository,
): ViewModel() {


    private val _resourceState: MutableLiveData<Resource<List<Gnome>>> = MutableLiveData()
    val resourceState: LiveData<Resource<List<Gnome>>> = _resourceState

    fun setResourceState(resourceState: ResourceState) {

        _resourceState.value = Resource.Loading

        viewModelScope.launch {
            when(resourceState){
                is ResourceState.GetBrastlewarkPopulation -> {
                    repository.getAllGnomes().onEach { resourceState ->
                        _resourceState.value = resourceState
                    }.launchIn(viewModelScope)
                }
                is ResourceState.GetFilteredBlastewarkPopulation -> {
                    val query = resourceState.name.lowercase(Locale.getDefault())
                    if (query.isNotEmpty()) {
                        val filteredList = resourceState.gnomeList.filter { gnome ->
                            gnome.name.lowercase(Locale.getDefault()).contains(query) || gnome.professions.any {
                                it.lowercase(Locale.getDefault()).contains(
                                    query
                                )
                            }
                        }
                        _resourceState.value = Resource.FilteredGnomes(filteredList)
                    } else {
                        _resourceState.value = Resource.FilteredGnomes(resourceState.gnomeList)
                    }
                }
            }
        }
    }
}


sealed class ResourceState{
    object GetBrastlewarkPopulation: ResourceState()
    class GetFilteredBlastewarkPopulation(val name: String, val gnomeList: List<Gnome>) : ResourceState()
}
