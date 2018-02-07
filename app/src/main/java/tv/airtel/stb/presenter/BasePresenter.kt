package tv.airtel.stb.presenter

import tv.airtel.stb.view.BaseView

/**
 * Created by VipulKumar on 1/12/18.
 * Base class for the presenters in MVP.
 */
open class BasePresenter<ViewType : BaseView> : Presenter {
    /**
     * Presenters have a lifecycle which can be observed
     */
    private var presenterLifecycleCallbacks: PresenterLifecycleCallbacks? = null
    /**
     * View passed to presenter
     */
    var view: ViewType? = null

    /**
     * Boolean to check the state of a presenter
     */
    var isActive: Boolean = false

    /**
     * Lifecycle method of presenter. Essentially tied with onResume() of view
     */
    override fun resume() {
        presenterLifecycleCallbacks?.onResume(this)
        isActive = true
    }

    /**
     * Lifecycle method of presenter. Essentially tied with onPause() of view
     */
    override fun pause() {
        presenterLifecycleCallbacks?.onPause(this)
        isActive = false
    }

    /**
     * Lifecycle method of presenter. Essentially tied with onDestroy() of view
     */
    override fun destroy() {
        presenterLifecycleCallbacks?.onDestroy(this)
        isActive = false
        presenterLifecycleCallbacks = null
        detachView()
    }

    /**
     * Set a view to this presenter
     * @param viewType View to be attached.
     */
    fun attachView(viewType: ViewType) {
        view = viewType
    }

    /**
     * Sets the view to null
     */
    fun detachView() {
        view = null
    }

    /**
     * View is considered to be attached if it is not null
     */
    fun isViewAttached() = view != null

    fun registerLifecycleCallbacks(presenterLifecycleCallbacks: PresenterLifecycleCallbacks) {
        this.presenterLifecycleCallbacks = presenterLifecycleCallbacks
    }

    abstract class PresenterLifecycleCallbacks {
        open fun onResume(basePresenter: BasePresenter<*>) {}
        open fun onPause(basePresenter: BasePresenter<*>) {}
        open fun onDestroy(basePresenter: BasePresenter<*>) {}
    }
}