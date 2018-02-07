package tv.airtel.stb.presentation

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import tv.airtel.stb.presenter.Presenter

/**
 * Created by VipulKumar on 1/16/18.
 * A utility class that ties the lifecycle of presenter with the lifecycle of activity or fragment.
 */
object PresenterLifecycle {
    /**
     * Attaches the lifecycle of presenter with the lifecycle of fragment
     */
    fun registerPresenterLifecycle(fragment: Fragment, presenter: Presenter) {
        val fragmentManager = fragment.fragmentManager
        fragmentManager?.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentPaused(fm: FragmentManager?, f: Fragment?) {
                        if (f === fragment) {
                            presenter.pause()
                        }
                    }

                    override fun onFragmentResumed(fm: FragmentManager?, f: Fragment?) {
                        if (f === fragment) {
                            presenter.resume()
                        }
                    }

                    override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                        if (f === fragment) {
                            presenter.destroy()
                            fragmentManager.unregisterFragmentLifecycleCallbacks(this)
                        }
                    }

                }, false)
    }

    /**
     * Attaches the lifecycle of presenter with the lifecycle of activity
     */
    fun registerPresenterLifecycle(appActivity: Activity, presenter: Presenter) {
        appActivity.application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
                if (activity == appActivity) {
                    presenter.pause()
                }
            }

            override fun onActivityResumed(activity: Activity?) {
                if (activity == appActivity) {
                    presenter.resume()
                }
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
                if (activity == appActivity) {
                    presenter.destroy()
                }
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            }

        })
    }
}