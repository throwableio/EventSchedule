package io.throwable.eventschedule.ui.schedule

import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.throwable.eventschedule.R
import io.throwable.eventschedule.inflate
import io.throwable.eventschedule.model.PostItem
import io.throwable.eventschedule.ui.post.PostAdapter
import kotlinx.android.synthetic.main.item_post.view.*
import kotlinx.android.synthetic.main.schedule_item.view.*

class ScheduleAdapter: RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    private var items = ArrayList<Schedule>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder = ViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.schedule_item)) {

        fun bind(items: Schedule) {
            itemView.schedule_name.text = items.schedule_name
            itemView.schedule_time.text = items.schedule_time
            itemView.location.text = items.schedule_location
            val context = itemView.context

            when(items.schedule_label_color){
                ScheduleFragment.RED -> itemView.left_layout.setBackgroundColor(Color.parseColor(context.resources.getString(R.string.colorRed)))
                ScheduleFragment.BLUE ->  itemView.left_layout.setBackgroundColor(Color.parseColor(context.resources.getString(R.string.colorBlue)))
                ScheduleFragment.YELLOW ->  itemView.left_layout.setBackgroundColor(Color.parseColor(context.resources.getString(R.string.colorYellow)))
                ScheduleFragment.GREEN ->  itemView.left_layout.setBackgroundColor(Color.parseColor(context.resources.getString(R.string.colorGreen)))
            }

        }
    }

    fun addItems(list: List<Schedule>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }
}