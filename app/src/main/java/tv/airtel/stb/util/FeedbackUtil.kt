package tv.airtel.stb.util

import android.content.Context
import tv.airtel.stb.widget.SaneToast

/**
 * Created by VipulKumar on 1/19/18.
 * Utility to show all kinds of feedback.
 */

object FeedbackUtil {
    fun showMessage(context: Context?, message: String?) {
        SaneToast.getToast(context, message).show()
    }
}
