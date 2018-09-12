package io.throwable.eventschedule.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import io.throwable.eventschedule.R
import io.throwable.eventschedule.ui.chats.ChatsFragment
import io.throwable.eventschedule.ui.schedule.ScheduleFragment
import io.throwable.eventschedule.ui.speakers.Speaker
import io.throwable.eventschedule.ui.speakers.SpeakerDetailFragment
import io.throwable.eventschedule.ui.speakers.SpeakersFragment
import io.throwable.eventschedule.ui.venues.VenueFragment
import kotlinx.android.synthetic.main.activity_home.*
import io.throwable.eventschedule.utils.BottomNavigationHelper
import kotlinx.android.synthetic.main.app_toolbar_extended.*



class HomeActivity : AppCompatActivity(),
        SpeakerDetailFragment.OnFragmentInteractionListener,
        SpeakersFragment.OnListFragmentInteractionListener,
        VenueFragment.OnFragmentInteractionListener,
        ChatsFragment.OnFragmentInteractionListener{
    override fun onVenueChanged() {

    }

    override fun sendMessage(message: String) {

    }

    override fun onSpeakerSelected(item: Speaker) {
        setFragment(SpeakerDetailFragment())
        tool.visibility = GONE
    }

    override fun onSpeakerLiked(item: Speaker) {

    }

    companion object {
        const val ROOT_FRAGMENT = "root"
        var fragment : Fragment? = null
    }

    override fun onSwtichStateChanged(state: Boolean) {

    }

    private val mOnNavigationItemSelectedListener
            = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_schedule -> {
                popFragment()
                setFragment(ScheduleFragment())
                tool.visibility = VISIBLE
                titleLarge.text = ("Schedule")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_venue -> {
                popFragment()
                tool.visibility = VISIBLE
                titleLarge.text = ("Venue")
                setFragment(VenueFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_speaker -> {
                popFragment()
                setFragment(SpeakersFragment())
                tool.visibility = VISIBLE
                titleLarge.text = ("Speakers")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                popFragment()
                tool.visibility = VISIBLE
                titleLarge.text = ("Chats")
                setFragment(ChatsFragment())
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
    }

    override fun onResume() {
        super.onResume()
        BottomNavigationHelper.disableShiftMode(navigation)
        navigation.selectedItemId = R.id.navigation_schedule
    }

    override fun onBackPressed() {
        when {
            fragment!! is ScheduleFragment -> {
                super.onBackPressed()
            }
            fragment!! is SpeakerDetailFragment -> {
                tool.visibility = VISIBLE
                titleLarge.text = ("Speakers")
                setFragment(SpeakersFragment())
            }
            else -> {
                navigation.selectedItemId = R.id.navigation_schedule
                setFragment(ScheduleFragment())
            }
        }

    }

    private fun setFragment(fragment: Fragment) {
        Companion.fragment = fragment
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
