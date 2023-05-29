package ge.neirondev.kitchenrecipe.domain.di

import android.content.Context

import dagger.BindsInstance
import dagger.Component
import ge.neirondev.kitchenrecipe.presentation.MainActivity

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class

    ]
)
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
            //@BindsInstance feedPost: FeedPost,
        ): ApplicationComponent
    }
}
