package de.ganddev.oboobs;

import android.databinding.BaseObservable;

import de.ganddev.oboobs.data.Boobs;

/**
 * Created by bjornahlfeld on 29.09.17.
 */

public class BoobsItemViewModel extends BaseObservable {

    private Boobs boobs;

    public BoobsItemViewModel(Boobs boobs) {
        this.boobs = boobs;
    }

    public void setBoobs(Boobs boobs) {
        this.boobs = boobs;
        notifyChange();
    }

    public String getImageUrl() {
        return "http://media.oboobs.ru/"+boobs.getPreview();
    }
}
