package tv.airtel.stb.widget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import tv.airtel.stb.R

/**
 * A Toast built with custom UI and Singleton pattern.
 */

object SaneToast {
    private var SANE_TOAST: Toast? = null

    fun getToast(context: Context?): Toast {
        if (SANE_TOAST == null) {
            SANE_TOAST = Toast(context)
        }
        return SANE_TOAST as Toast
    }

    fun getToast(context: Context?, message: String?): Toast {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.widget_toast, null)
        val text = layout.findViewById<TextView>(R.id.tv_toast_msg)
        text.text = message

        //Prevent creating multiple toasts at a time
        val toast = getToast(context)
        toast.view = layout
        toast.duration = Toast.LENGTH_SHORT
        return toast
    }

    fun getToast(context: Context?, message: String?, length: Int): Toast {
        val toast = getToast(context, message)
        toast.duration = length
        return toast
    }

    fun getToast(context: Context?, message: String?, iconResource: Int?): Toast {
        val toast = getToast(context, message)
        val view = toast.view
        val imageView = view.findViewById<ImageView>(R.id.iv_toast_icon)
        imageView.visibility = View.VISIBLE
        imageView.setImageResource(iconResource!!)
        toast.view = view
        return toast
    }
}
