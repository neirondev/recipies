package ge.neirondev.kitchenrecipe.data.repository

import ge.neirondev.kitchenrecipe.data.model.Root
import ge.neirondev.kitchenrecipe.data.network.ApiService
import ge.neirondev.kitchenrecipe.extension.mergeWith
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : RecipesRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private val nextDataNeededEvents = MutableSharedFlow<Unit>(replay = 1)
    private val refreshedListFlow = MutableSharedFlow<List<Root>>()

    private val _recipies = Root()
    private val recipies: Root
    get() = _recipies

    private val loadedListFlow = flow{
        nextDataNeededEvents.emit(Unit)
        nextDataNeededEvents.collect {
            val recipes = apiService.
            loadRecipies("473dd0215dmsh464e6ad6ad7de65p10d34ejsn3f3c86e91afa","tasty.p.rapidapi.com")
            emit(recipes)
        }
    }
    private val recipes: StateFlow<Root> = loadedListFlow
        //.mergeWith(refreshedListFlow)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = recipies
        )


    override fun getRecipesFlow(): StateFlow<Root> = recipes

}