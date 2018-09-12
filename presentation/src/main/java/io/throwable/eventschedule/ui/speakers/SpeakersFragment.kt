package io.throwable.eventschedule.ui.speakers

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.throwable.eventschedule.R

import kotlinx.android.synthetic.main.fragment_speakers.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [SpeakersFragment.OnListFragmentInteractionListener] interface.
 */
class SpeakersFragment : Fragment() {

    private var listener: OnListFragmentInteractionListener? = null
    private val mAdapter = SpeakersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        with(speakersList) {
            adapter = mAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
        mockData()
    }

    private fun mockData() {
        val list = mutableListOf<Speaker>()
        list.add(Speaker("Nsikak Thompson", "@thompson_nsikak",
                "Introduction to Firebase", R.drawable.nsikak, "Firebase",
                "#43A4EB"))
        list.add(Speaker("Edidiong Asikpo", "@didicodes",
                "ML Kit with Android", R.drawable.asikpo, "Machine Learning",
                "#62D582"))
        list.add(Speaker("Emmanuel Obot", "@emma_robot",
                "PWA Smart Home", R.drawable.emma, "PWA",
                "#E44E7B"))
        list.add(Speaker("Edidiong Asikpo", "@didicodes",
                "Jetpack Smart", R.drawable.asikpo, "ANDROID",
                "#62D582"))
        list.add(Speaker("Edidiong Asikpo", "@didicodes",
                "ML Kit with Android", R.drawable.asikpo, "Machine Learning",
                "#1FD7E4"))
        list.add(Speaker("Nsikak Thompson", "@thompson_nsikak",
                "Introduction to Firebase", R.drawable.nsikak, "Firebase",
                "#43A4EB"))
        mAdapter.addSpeakers(list)
        if(listener != null)
            mAdapter.setListener(listener!!)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        fun onSpeakerSelected(item: Speaker)
        fun onSpeakerLiked(item: Speaker)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                SpeakersFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
