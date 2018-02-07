package tv.airtel.stb.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import tv.accedo.airtel.wynk.data.utils.ConfigurationManager
import javax.inject.Inject

/**
 * Created by VipulKumar on 1/16/18.
 * Base activity that handles injections, fragmentTransactions ...
 */

@Suppress("unused")
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    /** Returns an [AndroidInjector] of [Fragment]s.  */
    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Temporarily setting the value of base url as we do not have ConfigurationManager setup yet
        ConfigurationManager.MIDDLEWARE_END_POINT_CONTENT_LAYOUT_API = "https://content.airtel.tv/"
    }

    fun replaceFragment(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(id, fragment)
                .commit()
    }

    fun addFragment(id: Int, fragment: Fragment?) {
        supportFragmentManager.beginTransaction()
                .add(id, fragment)
                .commit()
    }

    fun addFragment(id: Int, fragment: Fragment?, animationIn: Int, animationOut: Int) {
        supportFragmentManager.beginTransaction()
                .add(id, fragment)
                .setCustomAnimations(animationIn, animationOut)
                .commit()
    }

    fun replaceFragment(id: Int, fragment: Fragment, backStack: String) {
        supportFragmentManager.beginTransaction()
                .replace(id, fragment)
                .addToBackStack(backStack)
                .commit()
    }

    fun removeFragment(fragment: Fragment?) {
        supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
    }
}
