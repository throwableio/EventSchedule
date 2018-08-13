package io.throwable.domain.repository

import io.throwable.domain.model.Post
import io.reactivex.Single

interface AppRemote {

    fun fetchPost(): Single<List<Post>>
}