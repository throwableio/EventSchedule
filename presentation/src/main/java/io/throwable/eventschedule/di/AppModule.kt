package io.throwable.eventschedule.di

import android.arch.persistence.room.Room
import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import io.throwable.eventschedule.App
import io.throwable.data.cache.AppCache
import io.throwable.data.cache.AppCacheImpl
import io.throwable.data.cache.helper.IPreferenceHelper
import io.throwable.data.cache.helper.IPreferenceHelperImpl
import io.throwable.data.db.AppDatabase
import javax.inject.Singleton


@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app

    @Provides
    fun provideContext(): Context { return app.applicationContext}

    /**
     * Room Database instance
     * @param app application context
     */
    @Provides
    @Singleton
    fun provideAppDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(app.applicationContext, AppDatabase::class.java, "base.db").build()
    }

    /**
     * AppCache instance
     * @param appCacheImpl
     */
    @Provides
    @Singleton
    fun provideAppCache(appCacheImpl: AppCacheImpl): AppCache = appCacheImpl


    @Provides
    @Singleton
    fun providePreferenceHelper(ipreference: IPreferenceHelperImpl): IPreferenceHelper = ipreference
    
    @Provides
    @Singleton
    fun provideFireStore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    
    
    
}