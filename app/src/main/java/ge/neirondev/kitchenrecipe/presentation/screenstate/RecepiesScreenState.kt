package ge.neirondev.kitchenrecipe.presentation.screenstate

import ge.neirondev.kitchenrecipe.data.model.Root

sealed class RecepiesScreenState{
    object Initial: RecepiesScreenState()
    object Loading: RecepiesScreenState()
    data class Recepies(val recepies: Root): RecepiesScreenState()
    data class Error(val error: String): RecepiesScreenState()
}
