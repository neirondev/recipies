package ge.neirondev.kitchenrecipe.domain.entity

import ge.neirondev.kitchenrecipe.data.model.Nutrition

class ReceiptItem(
    val id: Int,
    val cookTomeMin: Int,
    val description: String,
    val imageUri: String,
    val name: String,
    val thumbnailUrl: String,
    val videoUrl: String,
    val totalTimeTier: String,
    val nutrition: NutritionEntity
    )