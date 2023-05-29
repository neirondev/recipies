package ge.neirondev.kitchenrecipe.domain.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ge.neirondev.kitchenrecipe.presentation.viewmodel.RecepiesViewModel

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(RecepiesViewModel::class)
    @Binds
    fun bindRecepiesViewModel(viewModel: RecepiesViewModel): ViewModel
}