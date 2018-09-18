package io.throwable.eventschedule.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import io.throwable.eventschedule.R
import io.throwable.eventschedule.ui.schedule.ScheduleFragment
import io.throwable.eventschedule.ui.speakers.SpeakerDetailFragment
import io.throwable.eventschedule.ui.venue.VenueFragment
import kotlinx.android.synthetic.main.activity_home.*
import io.throwable.eventschedule.utils.BottomNavigationHelper
import kotlinx.android.synthetic.main.app_toolbar_extended.*



class HomeActivity : AppCompatActivity(), SpeakerDetailFragment.OnFragmentInteractionListener {

    companion object {
        const val ROOT_FRAGMENT = "root"
    }

    override fun onSwtichStateChanged(state: Boolean) {

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_schedule -> {
                setFragment(ScheduleFragment())
                tool.visibility = VISIBLE
                titleLarge.text = ("Schedule")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_venue -> {
                tool.visibility = GONE
                titleLarge.text = ("Venue")
                setFragment(VenueFragment.getFragment(VenueFragment.DummyData.generateEventVenue()))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_speaker -> {
                setFragment(SpeakerDetailFragment())
                tool.visibility = GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                popFragment()
                tool.visibility = VISIBLE
                titleLarge.text = ("News")
                return@OnNavigationItemSelectedListener true
            }
            else -> {setFragment(ScheduleFragment())}
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        BottomNavigationHelper.disableShiftMode(navigation)
        navigation.selectedItemId = R.id.navigation_schedule
    }

    private fun setFragment(fragment: Fragment) {
        popFragment()
        supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                .replace(R.id.fragment_container, fragment, ROOT_FRAGMENT)
                .commit()
    }

    private fun popFragment() {
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
        val fragment = supportFragmentManager.findFragmentByTag(ROOT_FRAGMENT)

        if (fragment != null)
            supportFragmentManager.beginTransaction().remove(fragment).commit()
    }

}
