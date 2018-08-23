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

    private fun prepareMockData() {
        var list = mutableListOf<Schedule>()
        list.add(Schedule("Breakfast", "7:00 PM", "Dinner Room", R.color.colorYellow))
        list.add(Schedule("Breakfast", "7:00 PM", "Dinner Room", R.color.colorRed))
        list.add(Schedule("Breakfast", "7:00 PM", "Dinner Room", R.color.colorYellow))
        list.add(Schedule("Breakfast", "7:00 PM", "Dinner Room", R.color.colorRed))
        list.add(Schedule("Breakfast", "7:00 PM", "Dinner Room", R.color.colorYellow))
        list.add(Schedule("Breakfast", "7:00 PM", "Dinner Room", R.color.colorRed))


        mAdapter.addItems(list)
    }

}