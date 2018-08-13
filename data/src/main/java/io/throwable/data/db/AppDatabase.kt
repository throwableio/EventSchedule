package io.throwable.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.throwable.data.model.PostEntity

@Database(entities = arrayOf(PostEntity::class), version = 1)
public abstract class AppDatabase: RoomDatabase() {

   public abstract fun postDao(): PostDao
}