package io.throwable.eventschedule

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.throwable.eventschedule.ui.post.PostActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, PostActivity::class.java))
        finish()
    }
}
