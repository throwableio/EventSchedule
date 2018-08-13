package io.throwable.eventschedule.ui.post

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.throwable.eventschedule.Data
import io.throwable.eventschedule.DataState
import io.throwable.eventschedule.model.PostItem
import io.throwable.eventschedule.model.PostItemMapper
import io.throwable.data.cache.helper.IPreferenceHelper
import io.throwable.domain.usecase.UserPostUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel @Inject constructor(private val useCase: UserPostUseCase,
                                        private val mapper: PostItemMapper,
                                        private val preference: IPreferenceHelper) : ViewModel(){

    val posts = MutableLiveData<Data<List<PostItem>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        getPost()
    }

    fun getPost(refresh: Boolean = false) =
            compositeDisposable.add(useCase.getPost(refresh)
                    .doOnSubscribe { posts.postValue(Data(dataState = DataState.LOADING, data = posts.value?.data, message = null)) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .map { mapper.mapToPresentation(it) }
                    .subscribe({
                        posts.postValue(Data(dataState = DataState.SUCCESS, data = it, message = null))
                    }, { posts.postValue(Data(dataState = DataState.ERROR, data = posts.value?.data, message = it.message)) }))



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}