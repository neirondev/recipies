package ge.neirondev.kitchenrecipe.domain.di

import android.content.Context


import dagger.Binds
import dagger.Module
import dagger.Provides
import ge.neirondev.kitchenrecipe.data.network.ApiFactory
import ge.neirondev.kitchenrecipe.data.network.ApiService
import ge.neirondev.kitchenrecipe.data.repository.RecipesRepository
import ge.neirondev.kitchenrecipe.data.repository.RecipesRepositoryImpl

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: RecipesRepositoryImpl): RecipesRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }


    }
}
