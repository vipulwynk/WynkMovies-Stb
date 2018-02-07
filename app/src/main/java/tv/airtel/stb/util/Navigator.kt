@file:Suppress("unused")

package tv.airtel.stb.util

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View

/**
 * Authored by VipulKumar on 18/09/17.
 *
 */

object Navigator {
    fun startActivityWithClipReveal(context: Context, landingActivity: Class<*>, view: View?) {
        val intent = Intent(context, landingActivity)
        val options: ActivityOptions?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && view != null) {
            options = ActivityOptions.makeClipRevealAnimation(view, 0, 0,
                    view.width, view.height)
            context.startActivity(intent, options!!.toBundle())
        } else {
            context.startActivity(intent)
        }
    }

    fun startActivityWithClipReveal(context: Context, intent: Intent, view: View?) {
        val options: ActivityOptions?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && view != null) {
            options = ActivityOptions.makeClipRevealAnimation(view, 0, 0,
                    view.width, view.height)
            context.startActivity(intent, options!!.toBundle())
        } else {
            context.startActivity(intent)
        }
    }

    fun startActivity(context: Context, landingActivity: Class<*>) {
        val intent = Intent(context, landingActivity)
        context.startActivity(intent)
    }

    fun startActivity(context: Context, landingActivity: Class<*>, bundle: Bundle) {
        val intent = Intent(context, landingActivity)
        context.startActivity(intent, bundle)
    }

    fun startActivity(context: Context, intent: Intent) {
        context.startActivity(intent)
    }

    fun startActivity(context: Context, intent: Intent, bundle: Bundle) {
        context.startActivity(intent, bundle)
    }
}
