package io.throwable.data.repository

import io.throwable.data.cache.AppCache
import io.throwable.data.mapper.PostMapper
import io.throwable.domain.model.Post
import io.throwable.domain.repository.AppRemote
import io.throwable.domain.repository.PostRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 *  This class implements the post repository logic from the domain layer
 *  @param appCache
 */
class PostRepositoryImpl @Inject constructor(private val appCache: AppCache,
                                             private val remote: AppRemote,
                                             private val mapper: PostMapper) : PostRepository {

    /**
     *  Fetching from the local db source to the domain
     *  @param refresh progress state
     */
    override fun getAllPost(refresh: Boolean): Flowable<List<Post>> {
        return appCache.getAllPost().map { mapper.mapToDomain(it) }
    }

    /**
     *  Fetching from the remote source to the domain
     *  @param refresh progress state
     */
    override fun fetchPost(refresh: Boolean): Single<List<Post>> =
            remote.fetchPost().doOnSuccess { it ->
                kotlin.run {
                    appCache.insertPost(mapper.mapToEntity(it)).subscribe()
                }

            }
}