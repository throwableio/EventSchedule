package io.throwable.data.cache

import io.throwable.data.model.PostEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface AppCache {
    fun insertPost(entity: List<PostEntity>): Completable
    fun getAllPost(): Flowable<List<PostEntity>>
}