package io.throwable.eventschedule.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import io.throwable.eventschedule.R
import kotlinx.android.synthetic.main.activity_home.*
import io.throwable.eventschedule.utils.BottomNavigationHelper


class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_schedule -> {
                message.text = ("Schedule")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_venue -> {
                message.text = ("Venue")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_speaker -> {
                message.text = ("Speakers")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                message.text = ("News")
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

}
