package ge.neirondev.kitchenrecipe.presentation.screenstate

import ge.neirondev.kitchenrecipe.data.model.Root
import ge.neirondev.kitchenrecipe.domain.entity.ReceiptItem

sealed class RecepiesScreenState{
    object Initial: RecepiesScreenState()
    object Loading: RecepiesScreenState()
    data class Recepies(val recepies: List<ReceiptItem>): RecepiesScreenState()
    data class Error(val error: String): RecepiesScreenState()
}
