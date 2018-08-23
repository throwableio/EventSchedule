package io.throwable.eventschedule

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.throwable.eventschedule.ui.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
