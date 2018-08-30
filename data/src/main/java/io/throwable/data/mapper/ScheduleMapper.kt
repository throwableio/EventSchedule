package io.throwable.data.mapper

import com.google.firebase.firestore.DocumentSnapshot
import io.throwable.data.model.ScheduleEntity
import io.throwable.domain.model.Schedule
import javax.inject.Inject

class ScheduleMapper @Inject constructor(){
    
    fun mapToDomain(entity: ScheduleEntity): Schedule = Schedule(entity.title,
            entity.time,
            entity.venue)
    
    fun mapToDomain(list: List<ScheduleEntity>): List<Schedule> = list.map { mapToDomain(it) }
    
    fun mapToEntity(schedule: Schedule): ScheduleEntity = ScheduleEntity(schedule.title,
            schedule.time,
            schedule.venue)
    
    fun mapToEntity(list: List<Schedule>): List<ScheduleEntity> = list.map { mapToEntity(it) }
    
    fun fromSnapShotToSchedule(it:DocumentSnapshot):List<Schedule>{
        //TODO: write mapper action
        return ArrayList<Schedule>()
    }
    
}