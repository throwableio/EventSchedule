package io.throwable.data.cache

import io.throwable.data.db.AppDatabase
import io.throwable.data.model.PostEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import timber.log.Timber
import javax.inject.Inject

/**
 *  This class implements the  database Cache logic
 *  @param database Room database instance
 */
class AppCacheImpl @Inject constructor(private val database: AppDatabase) : AppCache {

    /**
     *  This methods insert post into the database
     */
    override fun insertPost(entity: List<PostEntity>): Completable {
        return Completable.fromAction {
            kotlin.run {
                database.postDao().savePost(entity)
                getAllPost()
            }

        }
    }

    /**
     * This method returns all post from database
     */
    override fun getAllPost(): Flowable<List<PostEntity>> {
        return database.postDao().getAllPost().doOnNext { Timber.d("successfully fetched all post") }
    }

}