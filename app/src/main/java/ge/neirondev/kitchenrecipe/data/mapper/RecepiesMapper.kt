package ge.neirondev.kitchenrecipe.data.mapper

import ge.neirondev.kitchenrecipe.data.model.Nutrition
import ge.neirondev.kitchenrecipe.data.model.Root
import ge.neirondev.kitchenrecipe.domain.entity.NutritionEntity
import ge.neirondev.kitchenrecipe.domain.entity.ReceiptItem
import ge.neirondev.kitchenrecipe.presentation.ui.Nutrition

class RecepiesMapper() {


    companion object {
        fun mapResponseToRecepies(responseRoot: Root): List<ReceiptItem> {

            val recepies = mutableListOf<ReceiptItem>()
            responseRoot.results?.forEach {
                recepies.add(
                    ReceiptItem(
                        id = it.id,
                        cookTomeMin = it.cook_time_minutes,
                        description = it.description.orEmpty(),
                        imageUri = it.thumbnail_url.orEmpty(),//it.beauty_url.orEmpty(),
                        name = it.name.orEmpty(),
                        thumbnailUrl = it.thumbnail_url.orEmpty(),
                        videoUrl = it.video_url.orEmpty(),
                        totalTimeTier = it.total_time_tier?.display_tier.orEmpty(),
                        nutrition = mapResponseToNutrition(it.nutrition)
                    )
                )
            }
            return recepies
        }

        private fun mapResponseToNutrition(nutrition: Nutrition?): NutritionEntity {
            nutrition?.let { it
                return NutritionEntity(
                    fat = it.fat,
                    calories = it.calories,
                    sugar = it.sugar,
                    protein = it.protein
                )
            }
            return NutritionEntity()
        }
    }
}