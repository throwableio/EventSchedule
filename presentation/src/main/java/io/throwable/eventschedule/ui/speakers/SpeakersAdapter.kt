package io.throwable.eventschedule.ui.speakers

import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import io.throwable.eventschedule.R

import io.throwable.eventschedule.ui.speakers.SpeakersFragment.OnListFragmentInteractionListener


class SpeakersAdapter
    : RecyclerView.Adapter<SpeakersAdapter.ViewHolder>() {

    private var mValues: ArrayList<Speaker> = ArrayList()
    private var listener: OnListFragmentInteractionListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.speaker_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.bind(item)
        with(holder.v) {
            tag = item
            setOnClickListener {
                if (listener != null)
                    listener!!.onSpeakerSelected(item)
            }
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        val image: CircleImageView = v.findViewById(R.id.speaker_image)
        val name: TextView = v.findViewById(R.id.speaker_name)
        val handle: TextView = v.findViewById(R.id.speaker_handle)
        val like: ImageView = v.findViewById(R.id.like_btn)
        val title: TextView = v.findViewById(R.id.speech_title)
        val tag: TextView = v.findViewById(R.id.speech_tag)
        var speaker: Speaker? = null

        fun bind(speaker: Speaker) {
            this.speaker = speaker
            image.setImageResource(speaker.speaker_image_url)
            name.text = speaker.speaker_name
            handle.text = speaker.speaker_handle
            title.text = speaker.speech_title
            tag.text = speaker.speech_tag
            val color = Color.parseColor(speaker.label_color)
            val drawable = tag.background
            drawable.setColorFilter(color, PorterDuff.Mode.SRC)
            tag.background = null
            tag.background = drawable

        }

        override fun toString(): String {
            return super.toString() + " '" + speaker.toString() + "'"
        }
    }

    fun addSpeakers(list: List<Speaker>) {
        this.mValues.clear()
        this.mValues = ArrayList(list)
        notifyDataSetChanged()
    }

    fun setListener(listener: OnListFragmentInteractionListener) {
        this.listener = listener
    }
}
