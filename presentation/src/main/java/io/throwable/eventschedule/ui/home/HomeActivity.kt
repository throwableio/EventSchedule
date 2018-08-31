package io.throwable.eventschedule.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.throwable.eventschedule.R
import io.throwable.eventschedule.ui.schedule.ScheduleFragment
import io.throwable.eventschedule.ui.speakers.SpeakerDetailFragment
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
                popFragment()
                tool.visibility = VISIBLE
                titleLarge.text = ("Venue")
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
        showSignInDialog()
    }

    private fun showSignInDialog() {
        val inflater = LayoutInflater.from(this)
        val root = inflater.inflate(R.layout.google_sign_in_dialog, null)
        val signIn: Button = root.findViewById(R.id.sign_in)
        val cancel: TextView = root.findViewById(R.id.cancel)

        val builder = AlertDialog.Builder(this)
        builder.setView(root)
                .setCancelable(false)
        val dialog = builder.create()

        signIn.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this, "Waiting on you guys!", Toast.LENGTH_SHORT).show()
        }

        cancel.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "No personalized Schedule for you be that ooo",
                    Toast.LENGTH_LONG).show()
        }

        dialog.show()


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
