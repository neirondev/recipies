package ge.neirondev.kitchenrecipe.presentation

import android.app.Application
import ge.neirondev.kitchenrecipe.domain.di.ApplicationComponent
import ge.neirondev.kitchenrecipe.domain.di.DaggerApplicationComponent

class RecepiesApplication : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}