package de.ganddev.oboobs;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import de.ganddev.oboobs.data.Boobs;

/**
 * Created by bjornahlfeld on 29.09.17.
 */

public class BoobsItemViewModel extends ViewModel {

    private static final String TAG = BoobsItemViewModel.class.getSimpleName();
    public ObservableField<Boobs> boobs;

    public BoobsItemViewModel(@NonNull Boobs boobs) {
        this.boobs = new ObservableField<>(boobs);
    }

    public void setBoobs(Boobs boobs) {
        this.boobs.set(boobs);
    }

    public String getImageUrl() {
        return "http://media.oboobs.ru/"+boobs.get().getPreview();
    }
}
