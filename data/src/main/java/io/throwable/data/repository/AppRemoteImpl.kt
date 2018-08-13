package io.throwable.data.repository

import io.throwable.data.mapper.PostMapper
import io.throwable.data.remote.RemoteApi
import io.throwable.domain.model.Post
import io.throwable.domain.repository.AppRemote
import io.reactivex.Single
import javax.inject.Inject

/**
 * Here implements all the api interface
 * Binding this it to the domain
 * @param api retrofitr inteface
 * @param mapper data passer
 */
class AppRemoteImpl @Inject constructor(private val api: RemoteApi, private val mapper: PostMapper): AppRemote {

    override fun fetchPost(): Single<List<Post>> {
       return api.getPosts().map {it -> mapper.mapToDomain(it) }
    }
}