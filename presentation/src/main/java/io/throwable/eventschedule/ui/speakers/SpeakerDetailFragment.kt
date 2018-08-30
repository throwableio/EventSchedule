package io.throwable.eventschedule.ui.speakers

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.throwable.eventschedule.R
import kotlinx.android.synthetic.main.app_bar_layout.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SpeakerDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SpeakerDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SpeakerDetailFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_speaker_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleHolder.text = ("Speaker")
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
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
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onSwtichStateChanged(state: Boolean)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment SpeakerDetailFragment.
         */
        @JvmStatic
        fun newInstance() =
                SpeakerDetailFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}