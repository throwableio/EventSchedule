package io.throwable.eventschedule

import android.app.Application
import io.throwable.eventschedule.di.AppModule
import io.throwable.eventschedule.di.DaggerInjector
import io.throwable.eventschedule.di.Injector

class App : Application() {

    lateinit var injector: Injector private set

    override fun onCreate() {
        super.onCreate()

        /*Fabric.with(this, Crashlytics())*/

       initDagger()

    }

    /**
     * Initial Dagger Instance in the application class
     * Making this available anywhere in the app
     */
    private fun initDagger() {
        injector = DaggerInjector
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}