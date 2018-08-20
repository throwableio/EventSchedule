package io.throwable.eventschedule.ui.post

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.throwable.eventschedule.R
import io.throwable.eventschedule.inflate
import io.throwable.eventschedule.model.PostItem
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var items = ArrayList<PostItem>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder = ViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_post)) {

        fun bind(items: PostItem) {
            itemView.post_title.text = items.title
            itemView.post_descr.text = items.body

        }
    }

    fun addItems(list: List<PostItem>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }
}