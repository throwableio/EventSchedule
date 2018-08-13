package io.throwable.eventschedule.di

import dagger.Binds
import dagger.Module
import io.throwable.data.repository.PostRepositoryImpl
import io.throwable.domain.repository.PostRepository

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(repository: PostRepositoryImpl): PostRepository

}