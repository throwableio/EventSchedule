package io.throwable.eventschedule.ui.schedule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.throwable.eventschedule.R
import kotlinx.android.synthetic.main.fragment_schedule.*

class ScheduleFragment : Fragment() {


    var mAdapter = ScheduleAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    fun initView() {

        with(scheduleRecyclerView) {
            adapter = mAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
        prepareMockData()
    }

    /**
     * Dummy schedule list
      */
    private fun prepareMockData() {
        var list = mutableListOf<Schedule>()
        list.add(Schedule("Breakfast", "7:00 PM", "Dinner Room", ScheduleFragment.RED))
        list.add(Schedule("Registration", "7:00 PM", "Front Desk", ScheduleFragment.YELLOW))
        list.add(Schedule("Keynote", "7:00 PM", "Hall One", ScheduleFragment.GREEN))
        list.add(Schedule("Speaker Session 1", "11:00 PM", "Dinner Room", ScheduleFragment.GREEN))
        list.add(Schedule("Speaker Session 2", "9:00 PM", "Dinner Room", ScheduleFragment.GREEN))
        list.add(Schedule("Speaker Session 3", "20:00 PM", "Dinner Room", ScheduleFragment.BLUE))


        mAdapter.addItems(list)
    }


    companion object {
        @JvmField
        val GREEN = "green"

        @JvmField
        val RED = "red"

        @JvmField
        val YELLOW = "yellow"

        @JvmField
        val BLUE = "blue"
    }

}