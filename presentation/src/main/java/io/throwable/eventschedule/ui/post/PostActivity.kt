package io.throwable.eventschedule.ui.post

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.throwable.eventschedule.*
import io.throwable.eventschedule.model.PostItem
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PostActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val postAdapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAppInjector().inject(this)


        initViews()/*
        Crashlytics.getInstance().crash()*/

        withViewModel<PostViewModel>(viewModelFactory) {
            getPost(refresh = true)
            observe(posts, ::updatePosts)
        }

    }

    /**
     * Views initialization
     */
    fun initViews() {




        with(postsRecyclerView) {
            adapter = postAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@PostActivity)
        }
    }

    /**
     * adapter databinding
     * @param data [post list from the data layer]
     */
    private fun updatePosts(data: Data<List<PostItem>>?) {
        data?.let {
            when (it.dataState) {
                DataState.LOADING -> progressBar2.showProgress()
                DataState.SUCCESS -> progressBar2.hideProgress()
                DataState.ERROR -> progressBar2.hideProgress()
            }
            it.data?.let { postAdapter.addItems(it) }
            it.message?.let { toast(it, this@PostActivity) }
        }
    }
}
