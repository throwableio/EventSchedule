@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package io.throwable.eventschedule.utils


import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import io.throwable.eventschedule.R


private var mFragmentManager: FragmentManager? = null

var navigationListener: NavigationListener? = null


/**
 * @return true if the current fragment displayed is a root fragment
 */
val isRootFragmentVisible: Boolean
    get() = mFragmentManager!!.getBackStackEntryCount() <= 1


/**
 * Listener interface for navigation events.
 */
interface NavigationListener {

    /**
     * Callback on backstack changed.
     */
    fun onBackstackChanged()
}


/**
 * Initialize the NavigationManager with a FragmentManager, which will be used at the
 * fragment transactions.
 *
 * @param fragmentManager
 */
fun init(fragmentManager: FragmentManager) {
    mFragmentManager = fragmentManager
    mFragmentManager!!.addOnBackStackChangedListener {
        if (navigationListener != null) {
            navigationListener!!.onBackstackChanged()
        }
    }
}

/**
 * Displays the next fragment
 *
 * @param fragment
 */
private fun open(fragment: Fragment, container: Int) {
    if (mFragmentManager != null) {
        //@formatter:off
        mFragmentManager!!.beginTransaction()
                .replace(container, fragment)
                .setCustomAnimations(R.anim.slide_in_left,
                        R.anim.slide_out_right,
                        R.anim.slide_in_right,
                        R.anim.slide_out_left)
                .addToBackStack(fragment.toString())
                .commit()
        //@formatter:on
    }
}

/**
 * pops every fragment and starts the given fragment as a new one.
 *
 * @param fragment
 */
private fun openAsRoot(fragment: Fragment, container: Int) {
    popEveryFragment()
    open(fragment, container)
}


/**
 * Pops all the queued fragments
 */
private fun popEveryFragment() {
    // Clear all back stack.
    val backStackCount = mFragmentManager!!.getBackStackEntryCount()
    for (i in 0 until backStackCount) {

        // Get the back stack fragment id.
        val backStackId = mFragmentManager!!.getBackStackEntryAt(i).getId()

        mFragmentManager!!.popBackStack(backStackId, FragmentManager.POP_BACK_STACK_INCLUSIVE)

    }
}

/**
 * Navigates back by popping teh back stack. If there is no more items left we finish the current activity.
 *
 * @param baseActivity
 */
fun navigateBack(baseActivity: Activity) {

    if (mFragmentManager!!.backStackEntryCount === 0) {
        // we can finish the base activity since we have no other fragments
        baseActivity.finish()
    } else {
        mFragmentManager!!.popBackStackImmediate()
    }
}