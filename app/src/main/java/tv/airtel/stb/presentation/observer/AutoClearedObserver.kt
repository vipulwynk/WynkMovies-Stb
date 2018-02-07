package tv.airtel.stb.presentation.observer

import io.reactivex.observers.DisposableObserver
import tv.airtel.stb.presenter.BasePresenter

/**
 * Created by VipulKumar on 1/16/18.
 * A value holder that automatically clears the disposables if the presenter is destroyed.
 */

class AutoClearedObserver<out T : DisposableObserver<*>>(presenter: BasePresenter<*>, private var value: T?) {

    init {
        presenter.registerLifecycleCallbacks(object : BasePresenter.PresenterLifecycleCallbacks() {
            override fun onDestroy(basePresenter: BasePresenter<*>) {
                if (presenter == basePresenter) {
                    value?.dispose()
                }
            }
        })
    }

    fun get(): T? {
        return value
    }
}
