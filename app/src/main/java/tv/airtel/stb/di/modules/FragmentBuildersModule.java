package tv.airtel.stb.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import tv.airtel.stb.fragment.HomeContentListFragment;

/**
 * DI module for Fragments.
 */
@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract HomeContentListFragment contributeHomeContentListFragment();
}
