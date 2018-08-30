package io.throwable.domain.repository

import io.throwable.domain.model.Post
import io.reactivex.Single
import io.throwable.domain.model.Schedule
import io.throwable.domain.model.Speaker

interface AppRemote {

    fun fetchPost(): Single<List<Post>>
    fun fetchSchedule(): Single<List<Schedule>>
    fun fetchSpeakers(): Single<List<Speaker>>
}