package ge.neirondev.kitchenrecipe.data.repository

import ge.neirondev.kitchenrecipe.data.model.Root
import kotlinx.coroutines.flow.StateFlow

interface RecipesRepository {

    fun getRecipesFlow(): StateFlow<Root>

}
