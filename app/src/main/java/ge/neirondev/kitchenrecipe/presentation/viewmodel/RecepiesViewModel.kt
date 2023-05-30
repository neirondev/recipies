package ge.neirondev.kitchenrecipe.presentation.viewmodel

import androidx.lifecycle.ViewModel
import ge.neirondev.kitchenrecipe.data.mapper.RecepiesMapper
import ge.neirondev.kitchenrecipe.domain.usecases.GetRecipiesUseCase
import ge.neirondev.kitchenrecipe.presentation.screenstate.RecepiesScreenState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class RecepiesViewModel @Inject constructor(
    private val getRecipiesUseCase: GetRecipiesUseCase,
) : ViewModel() {
    private val recepiesFlow = getRecipiesUseCase()
    val screenState = recepiesFlow
        //.filter{it.isNotEmpty() }
        .map {root->
            val recipies = RecepiesMapper.mapResponseToRecepies(root)

            RecepiesScreenState.Recepies(recepies = recipies) as RecepiesScreenState
        }
        .onStart { emit(RecepiesScreenState.Loading) }
    //.mergeWith(loadNextDataFlow)
}