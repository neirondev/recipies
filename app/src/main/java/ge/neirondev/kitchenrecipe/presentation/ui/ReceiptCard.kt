package ge.neirondev.kitchenrecipe.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ge.neirondev.kitchenrecipe.R
import ge.neirondev.kitchenrecipe.domain.entity.ReceiptItem
import ge.neirondev.kitchenrecipe.ui.theme.KitchenRecipeTheme
import ge.neirondev.kitchenrecipe.ui.theme.ReceiptTheme
import ge.neirondev.kitchenrecipe.ui.theme.RecipesTheme
import ge.neirondev.kitchenrecipe.ui.theme.offsetGradientBackground

private val HighlightCardWidth = 170.dp
private val HighlightCardPadding = 16.dp

@Composable
fun ReceiptCard(
    modifier: Modifier = Modifier,
    receiptItem:ReceiptItem,
){
    Card(
        modifier = modifier
    ){
        AsyncImage(
            model = receiptItem.imageUri,
            modifier = Modifier.size(100.dp),
            //.fillMaxWidth(),
            //.wrapContentHeight(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ){
            val nutritionItem = receiptItem.nutrition
            Text(text = receiptItem.name)
            NutritionTable(
                calories = nutritionItem.calories,
                fat = nutritionItem.fat,
                sugar = nutritionItem.sugar,
                protein = nutritionItem.protein
            )

            Text(text = receiptItem.description)
            //Spacer(modifier = Modifier.height(8.dp))


        }
    }
}
@Composable
fun Nutrition() {

    Row {
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(
                iconResId = androidx.core.R.drawable.ic_call_answer,
                text = "calories",
                tint = MaterialTheme.colors.onSecondary
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(
                iconResId = androidx.core.R.drawable.ic_call_decline,
                text = "carbohydrates",
                tint = MaterialTheme.colors.onSecondary
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(
                iconResId = R.drawable.ic_launcher_foreground,
                text = "fat",
                tint = MaterialTheme.colors.onSecondary
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(
                iconResId = R.drawable.ic_launcher_foreground,
                text = "sugar",
                tint = MaterialTheme.colors.onSecondary
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(
                iconResId = R.drawable.ic_launcher_foreground,
                text = "fiber",
                tint = MaterialTheme.colors.onSecondary
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(
                iconResId = R.mipmap.ic_sugar,
                text = "protein",
                tint = MaterialTheme.colors.onSecondary
            )
        }

    }
}

@Composable
fun NutritionTable(
    calories: Int,
   // carbohydrates: String,
    fat: Int,
    sugar: Int,
   // fiber: String,
    protein: Int){
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        val modifier = Modifier
            .padding(2.dp)
            .size(80.dp, 40.dp)
        NutritionItem(modifier,"calories", calories.toString())
        NutritionItem(modifier,"fat", fat.toString())
        NutritionItem(modifier,"sugar", sugar.toString())
        NutritionItem(modifier,"protein", protein.toString())
    }
}

@Composable
fun NutritionItem(modifier: Modifier,label:String,value:String){
    Row() {
        Column() {
            Card(modifier = modifier){
                //modifier = Modifier.padding(2.dp)) {
                Column() {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.body1,
                        color = ReceiptTheme.colors.textPrimary,
                        modifier = Modifier
                            .padding(horizontal = 3.dp)
                            .width(80.dp),
                        textAlign = TextAlign.Center
                        )

                    Text(text = value,
                        style = MaterialTheme.typography.body1,
                        color = ReceiptTheme.colors.textSecondary,
                        modifier = Modifier
                            .padding(horizontal = 3.dp)
                            .width(80.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun IconWithText(
    iconResId: Int,
    text: String,
    onItemClickListener: (() -> Unit)? = null,
    tint: Color = MaterialTheme.colors.onSecondary
) {
    val modifier = if (onItemClickListener == null) {
        Modifier
    } else {
        Modifier.clickable {
            onItemClickListener()
        }
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(10.dp),
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = tint
        )
        Spacer(modifier = Modifier.width(4.dp))
        androidx.compose.material.Text(
            text = text,
            color = MaterialTheme.colors.onSecondary
        )
    }
}
@Composable
 fun HighlightSnackItem(
    receiptItem: ReceiptItem,
    onSnackClick: (Int) -> Unit,
    index: Int,
    gradient: List<Color>,
    gradientWidth: Float,
    scroll: Int,
    modifier: Modifier = Modifier
) {
    val left = index * with(LocalDensity.current) {
        (HighlightCardWidth + HighlightCardPadding).toPx()
    }
    JetsnackCard(
        modifier = modifier
            .size(
                width = 390.dp,
                height = 490.dp
            )
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = { onSnackClick(receiptItem.id) })
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(260.dp)
                    .fillMaxWidth()
            ) {
                val gradientOffset = left - (scroll / 3f)
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .offsetGradientBackground(gradient, gradientWidth, gradientOffset)
                )
                SnackImage(
                    imageUrl = receiptItem.imageUri,
                    contentDescription = null,
                    modifier = Modifier
                        .size(220.dp)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = receiptItem.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = ReceiptTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = receiptItem.description,
                style = MaterialTheme.typography.body1,
                color = ReceiptTheme.colors.textHelp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            val nutritionItem = receiptItem.nutrition
            NutritionTable(
                calories = nutritionItem.calories,
                fat = nutritionItem.fat,
                sugar = nutritionItem.sugar,
                protein = nutritionItem.protein
            )
        }
    }
}
@Composable
fun SnackImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    JetsnackSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            placeholder = painterResource(R.drawable.placeholder),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}


/*Preview
@Composable
fun previewIconWithText() {
    val recept = ReceiptItem(id = 0, cookTomeMin = 5, description = "description",
        imageUri = R.mipmap.ic_launcher,name = "salad", thumbnailUrl = "thumB",videoUrl =  "videoUrl",
    totalTimeTier = "5")
   KitchenRecipeTheme(false) {
        ReceiptCard(modifier = Modifier.padding(8.dp),recept)
    }
}
@Preview
@Composable
fun previewIconWithTextDark() {
    val recept = ReceiptItem(id = 0, cookTomeMin = 5, description = "description",
        imageUri = R.mipmap.ic_launcher,name = "salad", thumbnailUrl = "thumB",videoUrl =  "videoUrl",
        totalTimeTier = "5")
    RecipesTheme(true) {
        HighlightSnackItem(recept,{},0, listOf(Color.Red,Color.Blue),10f,10)
    }
}*/
