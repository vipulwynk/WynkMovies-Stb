package tv.airtel.stb.activity

import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*
import tv.airtel.stb.R
import tv.airtel.stb.util.Navigator

/**
 * Created by VipulKumar on 1/17/18.
 *
 */

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        delayAndLaunchMainActivity()
    }

    private fun delayAndLaunchMainActivity() {
        progress_bar.playAnimation()
        Handler().postDelayed({
            Navigator.startActivity(this, MainActivity::class.java)
        }, 4000)
    }
}
