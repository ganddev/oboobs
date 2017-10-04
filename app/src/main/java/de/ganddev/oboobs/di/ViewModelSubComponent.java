package de.ganddev.oboobs.di;

import dagger.Subcomponent;
import de.ganddev.oboobs.MainActivityViewModel;

/**
 * Created by bjornahlfeld on 04.10.17.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    MainActivityViewModel boobsListViewModel();
}
