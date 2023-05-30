package ge.neirondev.kitchenrecipe.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ge.neirondev.kitchenrecipe.R
import ge.neirondev.kitchenrecipe.data.model.Root
import ge.neirondev.kitchenrecipe.domain.entity.NutritionEntity
import ge.neirondev.kitchenrecipe.domain.entity.ReceiptItem
import ge.neirondev.kitchenrecipe.presentation.ViewModelFactory
import ge.neirondev.kitchenrecipe.presentation.screenstate.RecepiesScreenState
import ge.neirondev.kitchenrecipe.presentation.viewmodel.RecepiesViewModel
import ge.neirondev.kitchenrecipe.ui.theme.RecipesTheme

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

   /* RecipesTheme(false) {
        val recept = ReceiptItem(id = 0, cookTomeMin = 5, description = "description",
            imageUri = R.mipmap.ic_launcher,name = "salad", thumbnailUrl = "thumB",videoUrl =  "videoUrl",
            totalTimeTier = "5",
            nutrition = NutritionEntity(12,12,23,45))
        HighlightSnackItem(recept,{},0, listOf(Color.Red, Color.Blue),100f,100)
    }*/

   // ReceiptCard(receiptItem = ReceiptItem(1,1,"","","","","",""))
}
@Composable
private fun Recepies(
    viewModel: RecepiesViewModel,
    //paddingValues: PaddingValues,
    recepies: List<ReceiptItem>,
    //onItemClick: (Recepies) -> Unit,
    //nextDataIsLoading: Boolean
) {

    LazyColumn(
        //modifier = Modifier.padding(paddingValues),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            top = 16.dp, start = 8.dp, end = 8.dp, bottom = 16.dp
        ),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = recepies,
            key = { it.id }
        ){
            recepies ->
            HighlightSnackItem(recepies,{},0, listOf(Color.Red, Color.Blue),100f,100)
        }
    }

}