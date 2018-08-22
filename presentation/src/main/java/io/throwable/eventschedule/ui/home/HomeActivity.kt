package io.throwable.eventschedule.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import io.throwable.eventschedule.R
import kotlinx.android.synthetic.main.activity_home.*
import io.throwable.eventschedule.utils.BottomNavigationHelper
import kotlinx.android.synthetic.main.app_bar_layout.*


class HomeActivity : AppCompatActivity(), SpeakerDetailFragment.OnFragmentInteractionListener {

    companion object {
        const val ROOT_FRAGMENT = "root"
    }

    override fun onSwtichStateChanged(state: Boolean) {

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_schedule -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_venue -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_speaker -> {
                setFragment(SpeakerDetailFragment())
                titleHolder!!.text = ("Speaker")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        BottomNavigationHelper.disableShiftMode(navigation)
    }

    private fun setFragment(fragment: Fragment) {
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
        supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragment_container, fragment, ROOT_FRAGMENT)
                .commit()
    }

}
