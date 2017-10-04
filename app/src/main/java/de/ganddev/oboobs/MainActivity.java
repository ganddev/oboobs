package de.ganddev.oboobs;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import de.ganddev.oboobs.data.Boobs;
import link.fls.swipestack.SwipeStack;

public class MainActivity extends LifecycleActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityViewModel viewModel;
    private BoobsAdapter adapter;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);

        SwipeStack swipeStack = findViewById(R.id.swipeStack);
        swipeStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {
                viewModel.swipedToLeft(position % 3);
            }

            @Override
            public void onViewSwipedToRight(int position) {
               viewModel.swipedToRight(position % 3);
            }

            @Override
            public void onStackEmpty() {
                viewModel.loadNext();
            }
        });
        adapter = new BoobsAdapter(this);
        swipeStack.setAdapter(adapter);


        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel.class);
        viewModel.getBoobs().observe(this, new Observer<List<Boobs>>() {
                    @Override
                    public void onChanged(@Nullable List<Boobs> boobs) {
                        adapter.addAll(boobs);
                    }
                }
        );

    }
}