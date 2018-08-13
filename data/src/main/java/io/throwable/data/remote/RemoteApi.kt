package io.throwable.data.remote

import io.throwable.data.model.PostEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * All Api endpoint for this projects should be places here
 */

interface RemoteApi {

    @GET("jsonBlob/334061e9-90f3-11e8-ad06-a36a46942fa7/")
    @Headers("Accept: application/json",
            "Content-type:application/json")
    fun getPosts(): Single<List<PostEntity>>
}