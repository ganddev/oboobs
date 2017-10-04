package de.ganddev.oboobs;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import de.ganddev.oboobs.data.Boobs;
import de.ganddev.oboobs.data.BoobsRemoteDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bjornahlfeld on 29.09.17.
 */

public class MainActivityViewModel extends ViewModel implements Callback<List<Boobs>> {

    private static final int NUMBER_OF_BOOBS = 3;

    @NonNull
    private BoobsRemoteDataSource boobsRemoteDataSource;

    @NonNull
    private final MutableLiveData<List<Boobs>> boobs;

    @Inject
    public MainActivityViewModel(@NonNull BoobsRemoteDataSource boobsRemoteDataSource) {
       this.boobsRemoteDataSource = boobsRemoteDataSource;
        boobs = new MutableLiveData<>();
        loadRandomBoobs();
    }

    @NonNull
    public LiveData<List<Boobs>> getBoobs() {
        return boobs;
    }


    private void loadRandomBoobs() {
        boobsRemoteDataSource.getRandomBoobs(NUMBER_OF_BOOBS).enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Boobs>> call, Response<List<Boobs>> response) {
        if (response.isSuccessful()) {
            boobs.setValue(response.body());
        }
    }

    @Override
    public void onFailure(Call<List<Boobs>> call, Throwable t) {
    }

    public void loadNext() {
        loadRandomBoobs();
    }

    public void swipedToRight(int position) {
        rateBoobsNegative(position);
    }

    private void rateBoobsNegative(int position) {
        boobsRemoteDataSource.rateNoiseNegativ(boobs.getValue().get(position).getId()).enqueue(new Callback<Boobs>() {
            @Override
            public void onResponse(Call<Boobs> call, Response<Boobs> response) {

            }

            @Override
            public void onFailure(Call<Boobs> call, Throwable t) {

            }
        });
    }

    public void swipedToLeft(int position) {
        rateBoobsPositive(position);
    }

    private void rateBoobsPositive(int position) {
        boobsRemoteDataSource.rateNoisePositiv(boobs.getValue().get(position).getId()).enqueue(new Callback<Boobs>() {
            @Override
            public void onResponse(Call<Boobs> call, Response<Boobs> response) {

            }

            @Override
            public void onFailure(Call<Boobs> call, Throwable t) {

            }
        });
    }
}
