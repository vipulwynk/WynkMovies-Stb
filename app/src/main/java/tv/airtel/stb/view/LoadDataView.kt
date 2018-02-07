package tv.airtel.stb.view

/**
 * Created by VipulKumar on 1/16/18.
 *
 */
interface LoadDataView : BaseView {
    /**
     * Show a view with a progress bar indicating a loading process.
     */
    fun showLoading()

    /**
     * Hide a loading view.
     */
    fun hideLoading()

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    fun showRetry()

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    fun hideRetry()

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    fun showError(message: String?)
}