package tv.airtel.stb.activity

import android.os.Bundle
import tv.airtel.stb.R
import tv.airtel.stb.di.Injectable
import tv.airtel.stb.fragment.HomeContentListFragment

/**
 * Created by VipulKumar on 1/16/18.
 * Main activity to host all the fragments.
 */

class MainActivity : BaseActivity(), Injectable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHomeContentListFragment()
    }

    private fun setHomeContentListFragment() {
        replaceFragment(R.id.fragmentContainer, HomeContentListFragment.newInstance())
    }
}
