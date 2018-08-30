package io.throwable.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import io.throwable.data.mapper.PostMapper
import io.throwable.data.remote.RemoteApi
import io.throwable.domain.model.Post
import io.throwable.domain.repository.AppRemote
import io.reactivex.Single
import io.throwable.data.mapper.ScheduleMapper
import io.throwable.domain.model.Schedule
import io.throwable.domain.model.Speaker
import javax.inject.Inject

/**
 * Here implements all the api interface
 * Binding this it to the domain
 * @param api retrofitr inteface
 * @param mapper data passer
 */
class AppRemoteImpl @Inject constructor(private val api: RemoteApi,
                                        private val firestore: FirebaseFirestore,
                                        private val postMapper: PostMapper,
                                        private val scheduleMapper: ScheduleMapper): AppRemote {

    override fun fetchPost(): Single<List<Post>> {
       return api.getPosts().map {it -> postMapper.mapToDomain(it) }
    }


    
    override fun fetchSchedule(): Single<List<Schedule>> {
        val documentReference = firestore.collection("2018").document("schedule").get()
        
        return Single.create { e ->
            documentReference.addOnSuccessListener {
                e.onSuccess(scheduleMapper.fromSnapShotToSchedule(it))
            }
        }
    }
    
    
    override fun fetchSpeakers(): Single<List<Speaker>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}