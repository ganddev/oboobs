package de.ganddev.oboobs.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import de.ganddev.oboobs.MainActivity;

/**
 * Created by bjornahlfeld on 04.10.17.
 */
@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
