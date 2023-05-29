package ge.neirondev.kitchenrecipe.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date


// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
//header X-RapidAPI-Key
// 473dd0215dmsh464e6ad6ad7de65p10d34ejsn3f3c86e91afa

class Brand {
    var id = 0
    var slug: String? = null
    var image_url: String? = null
    var name: String? = null
}

class Component {
    var measurements: ArrayList<Measurement>? = null
    var raw_text: String? = null
    var extra_comment: String? = null
    var ingredient: Ingredient? = null
    var id = 0
    var position = 0
}

class Credit {
    var name: String? = null
    var type: String? = null
    var id = 0
    var slug: String? = null
    var image_url: String? = null
}

class Ingredient {
    var display_plural: String? = null
    var id = 0
    var display_singular: String? = null
    var updated_at = 0
    var name: String? = null
    var created_at = 0
}

class Instruction {
    var end_time = 0
    var temperature = 0
    var id = 0
    var position = 0
    var display_text: String? = null
    var start_time = 0
    var appliance: String? = null
}

class Measurement {
    var unit: Unit? = null
    var quantity: String? = null
    var id = 0
}

class Nutrition {
    var fat = 0
    var calories = 0
    var sugar = 0
    var carbohydrates = 0
    var fiber = 0
    var updated_at: Date? = null
    var protein = 0
}

class Price {
    var consumption_portion = 0
    var total = 0
    var updated_at: Date? = null
    var portion = 0
    var consumption_total = 0
}

class Rendition {
    var minimum_bit_rate = 0
    var name: String? = null
    var maximum_bit_rate = 0
    var url: String? = null
    var duration = 0
    var content_type: String? = null
    var aspect: String? = null
    var width = 0
    var height = 0
    var container: String? = null
    var poster_url: String? = null
    var file_size = 0
    var bit_rate = 0
}

class Result {
    var country: String? = null
    var tags: ArrayList<Tag>? = null
    var name: String? = null
    var compilations: ArrayList<Any>? = null
    var num_servings = 0
    var description: String? = null
    var promotion: String? = null
    var video_id = 0
    var keywords: String? = null
    var servings_noun_singular: String? = null
    var prep_time_minutes = 0
    var buzz_id: Any? = null
    var approved_at = 0
    var beauty_url: String? = null
    var nutrition_visibility: String? = null
    var slug: String? = null
    var thumbnail_alt_text: String? = null
    var renditions: ArrayList<Rendition>? = null
    var topics: ArrayList<Topic>? = null
    var seo_title: String? = null
    var original_video_url: String? = null
    var canonical_id: String? = null
    var cook_time_minutes = 0
    var instructions: ArrayList<Instruction>? = null
    var id = 0
    var sections: ArrayList<Section>? = null
    var total_time_minutes = 0
    var credits: ArrayList<Credit>? = null
    var servings_noun_plural: String? = null
    var language: String? = null
    var seo_path: Any? = null
    var user_ratings: UserRatings? = null
    var show_id = 0
    var nutrition: Nutrition? = null
    var show: Show? = null
    var updated_at = 0
    var price: Price? = null
    var brand: Brand? = null
    var brand_id = 0
    var draft_status: String? = null
    var thumbnail_url: String? = null
    var facebook_posts: ArrayList<Any>? = null
    var aspect_ratio: String? = null
    var inspired_by_url: String? = null
    var is_shoppable = false
    var video_ad_content: String? = null
    var yields: String? = null
    var tips_and_ratings_enabled = false
    var created_at = 0
    var video_url: String? = null
    var is_one_top = false
    var total_time_tier: TotalTimeTier? = null
}

//responce from api
class Root {
    var count = 0
    var results: ArrayList<Result>? = null
}

class Section {
    var components: ArrayList<Component>? = null
    var name: String? = null
    var position = 0
}

class Show {
    var name: String? = null
    var id = 0
}

class Tag {
    var type: String? = null
    var root_tag_type: String? = null
    var name: String? = null
    var id = 0
    var display_name: String? = null
}

class Topic {
    var name: String? = null
    var slug: String? = null
}

class TotalTimeTier {
    var tier: String? = null
    var display_tier: String? = null
}

class Unit {
    var name: String? = null
    var display_plural: String? = null
    var display_singular: String? = null
    var abbreviation: String? = null
    var system: String? = null
}

class UserRatings {
    var count_positive = 0
    var score = 0.0
    var count_negative = 0
}

/*val client = OkHttpClient()

val request = Request.Builder()
    .url("https://tasty.p.rapidapi.com/recipes/list?from=0&size=20&tags=under_30_minutes")
    .get()
    .addHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
    .addHeader("X-RapidAPI-Host", "tasty.p.rapidapi.com")
    .build()

val response = client.newCall(request).execute()*/

//base url https://tasty.p.rapidapi.com/
