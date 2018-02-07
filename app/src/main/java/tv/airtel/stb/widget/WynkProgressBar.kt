package tv.airtel.stb.widget

import android.content.Context
import android.util.AttributeSet

import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

/**
 * Created by VipulKumar on 1/19/18.
 *
 */

class WynkProgressBar : LottieAnimationView {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        setAnimation("anim_splashy.json")
        repeatCount = LottieDrawable.INFINITE
    }
}
