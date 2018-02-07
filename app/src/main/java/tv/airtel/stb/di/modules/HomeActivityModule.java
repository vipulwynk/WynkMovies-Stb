package tv.airtel.stb.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import tv.airtel.stb.activity.MainActivity;

@Module
public abstract class HomeActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeHomeActivity();
}
