package tv.airtel.stb.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tv.airtel.stb.R
import tv.airtel.stb.di.Injectable
import tv.airtel.stb.presentation.PresenterLifecycle
import tv.airtel.stb.presenter.HomeContentListPresenter
import tv.airtel.stb.util.FeedbackUtil
import tv.airtel.stb.view.HomeContentListView
import javax.inject.Inject

/**
 * Created by VipulKumar on 1/16/18.
 * Fragment to host content on homepage with [HomeContentListPresenter].
 */
class HomeContentListFragment : BaseFragment(), HomeContentListView, Injectable {
    @Inject
    lateinit var presenter: HomeContentListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PresenterLifecycle.registerPresenterLifecycle(this, presenter)

        presenter.attachView(this)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {
        FeedbackUtil.showMessage(context, "Success")
    }

    override fun showRetry() {

    }

    override fun hideRetry() {

    }

    override fun showError(message: String?) {
        FeedbackUtil.showMessage(context, message)
    }

    companion object {
        fun newInstance(): HomeContentListFragment {
            val args = Bundle()
            val fragment = HomeContentListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}