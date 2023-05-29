package ge.neirondev.kitchenrecipe.data.network

import ge.neirondev.kitchenrecipe.data.model.Root
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
@GET("recipes/list?from=0&size=20&tags=under_30_minutes")
suspend fun loadRecipies(
    @Header("X-RapidAPI-Key") token: String,
    @Header("X-RapidAPI-Host") host: String
   // @Query("X-RapidAPI-Key") token: String
): Root

}