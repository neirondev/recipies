package ge.neirondev.kitchenrecipe.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import ge.neirondev.kitchenrecipe.data.model.Root
import ge.neirondev.kitchenrecipe.presentation.ViewModelFactory
import ge.neirondev.kitchenrecipe.presentation.screenstate.RecepiesScreenState
import ge.neirondev.kitchenrecipe.presentation.viewmodel.RecepiesViewModel

@Composable
fun RecepiesScreen (
    viewModelFactory: ViewModelFactory,
    //paddingValues: PaddingValues,onItemClick: (Recepies) -> Unit
){
    val viewModel: RecepiesViewModel = viewModel(factory = viewModelFactory)
    val screenState = viewModel.screenState.collectAsState(initial = RecepiesScreenState.Initial)

    when (val currentState = screenState.value){
        is RecepiesScreenState.Recepies -> {
            Recepies(
                viewModel = viewModel,
                //paddingValues = paddingValues,
                recepies = currentState.recepies,
                //onItemClick = onItemClick,
                //nextDataIsLoading = currentState.nextDataIsLoading
            )
        }
        RecepiesScreenState.Initial -> {}
        RecepiesScreenState.Loading -> {}
        else -> {}
    }
}
private fun Recepies(
    viewModel: RecepiesViewModel,
    //paddingValues: PaddingValues,
    recepies: Root,
    //onItemClick: (Recepies) -> Unit,
    //nextDataIsLoading: Boolean
) {

}