package ge.neirondev.kitchenrecipe.domain.usecases

import ge.neirondev.kitchenrecipe.data.model.Root
import ge.neirondev.kitchenrecipe.data.repository.RecipesRepository
import kotlinx.coroutines.flow.StateFlow
import java.lang.reflect.Constructor
import javax.inject.Inject

class GetRecipiesUseCase @Inject constructor(
    private val repository: RecipesRepository
)  {
operator fun invoke(): StateFlow<Root>{
    return repository.getRecipesFlow()
}

}