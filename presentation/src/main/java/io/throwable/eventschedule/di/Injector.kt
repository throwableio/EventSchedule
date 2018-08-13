package io.throwable.eventschedule.di

import dagger.Component
import io.throwable.eventschedule.ui.post.PostActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, NetworkModule::class, RepositoryModule::class])
interface Injector {

    fun inject(activity: PostActivity)
}