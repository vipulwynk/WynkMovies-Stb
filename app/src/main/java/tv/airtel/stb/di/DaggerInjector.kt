package tv.airtel.stb.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import tv.airtel.stb.WynkApplication
import tv.airtel.stb.di.components.DaggerApplicationComponent
import tv.airtel.stb.di.modules.ApplicationModule

/**
 * Created by VipulKumar on 1/16/18.
 * Helper to inject all the activities and fragments marked Injectable.
 */

object DaggerInjector {
    fun injectAll(application: WynkApplication) {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(application))
                .build().inject(application)

        application
                .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                        injectComponents(activity)
                    }

                    override fun onActivityStarted(activity: Activity) {

                    }

                    override fun onActivityResumed(activity: Activity) {

                    }

                    override fun onActivityPaused(activity: Activity) {

                    }

                    override fun onActivityStopped(activity: Activity) {

                    }

                    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

                    }

                    override fun onActivityDestroyed(activity: Activity) {

                    }
                })
    }

    private fun injectComponents(activity: Activity) {
        if (activity is HasSupportFragmentInjector && activity is Injectable) {
            AndroidInjection.inject(activity)
        }
        (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?,
                                                   savedInstanceState: Bundle?) {
                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true)
    }
}
