package tv.airtel.stb

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import tv.airtel.stb.di.DaggerInjector
import javax.inject.Inject

/**
 * Created by VipulKumar on 1/16/18.
 *
 */

class WynkApplication : Application() , HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        DaggerInjector.injectAll(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            //TODO Use crash reporting
        }
    }
}
