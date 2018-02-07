package tv.airtel.stb.presentation.observer

import io.reactivex.observers.DisposableObserver
import timber.log.Timber

/**
 * Created by VipulKumar on 1/16/18.
 * A base observer for all network operations.
 */

abstract class NetworkObserver<Type> : DisposableObserver<Type>() {
    override fun onComplete() {
        Timber.d("Disposable completed")
        onNetworkComplete()
    }

    override fun onNext(value: Type) {
        Timber.d("Disposable Next")
        onNetworkNext(value)
    }

    override fun onError(e: Throwable) {
        Timber.d("Disposable Error")
        // Crashlytics.sendNetworkError(e)
        onNetworkError(e)
    }

    abstract fun onNetworkComplete()
    abstract fun onNetworkNext(value: Type?)
    abstract fun onNetworkError(e: Throwable)

}
