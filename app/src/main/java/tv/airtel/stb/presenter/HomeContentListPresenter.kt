package tv.airtel.stb.presenter

import tv.accedo.airtel.wynk.domain.interactor.DoMultipleContentRequest
import tv.accedo.airtel.wynk.domain.model.content.RowContents
import tv.airtel.stb.presentation.observer.AutoClearedObserver
import tv.airtel.stb.presentation.observer.NetworkObserver
import tv.airtel.stb.util.DataUtil
import tv.airtel.stb.view.HomeContentListView
import javax.inject.Inject

/**
 * Created by VipulKumar on 1/16/18.
 * Presenter for content list on Homepage.
 */
class HomeContentListPresenter @Inject
constructor(private val doMultipleContentRequest: DoMultipleContentRequest) : BasePresenter<HomeContentListView>() {
    private lateinit var multipleContentObserver: AutoClearedObserver<NetworkObserver<Map<String, RowContents>>>

    override fun resume() {
        super.resume()
        multipleContentObserver = AutoClearedObserver(this, getMultipleContentObserver())
        makeApiCall()
    }

    private fun getMultipleContentObserver(): NetworkObserver<Map<String, RowContents>> {
        return object : NetworkObserver<Map<String, RowContents>>() {
            override fun onNetworkComplete() {
                view?.hideLoading()
            }

            override fun onNetworkNext(value: Map<String, RowContents>?) {
            }

            override fun onNetworkError(e: Throwable) {
                view?.showError(e.localizedMessage)
            }
        }
    }

    private fun makeApiCall() {
        doMultipleContentRequest.execute(multipleContentObserver.get(), DataUtil.getMultipleContentParams())
    }
}