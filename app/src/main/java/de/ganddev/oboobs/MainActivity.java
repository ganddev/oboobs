package de.ganddev.oboobs;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import link.fls.swipestack.SwipeStack;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityViewModel viewModel;
    private BoobsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);

        SwipeStack swipeStack =  findViewById(R.id.swipeStack);
        swipeStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {
                viewModel.swipedToLeft(position);
            }

            @Override
            public void onViewSwipedToRight(int position) {
                Log.d(TAG, "onViewSwipedToRight");
                viewModel.swipedToRight(position);
            }

            @Override
            public void onStackEmpty() {
                Log.d(TAG, "onStackEmpty");
                viewModel.loadNext();
            }
        });
        adapter = new BoobsAdapter();
        swipeStack.setAdapter(adapter);


        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.setBoobsRemoteDataSource(APIUtils.getBoobsService());
        viewModel.getBoobs().observe(this, boobs -> {
            adapter.setItems(boobs);
            adapter.notifyDataSetChanged();
        });
    }
}
