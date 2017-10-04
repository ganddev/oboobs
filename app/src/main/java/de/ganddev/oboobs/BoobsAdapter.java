package de.ganddev.oboobs;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import de.ganddev.oboobs.data.Boobs;
import de.ganddev.oboobs.databinding.BoobsCardBinding;

/**
 * Created by bjornahlfeld on 29.09.17.
 */

public class BoobsAdapter extends ArrayAdapter<Boobs> {

    private static final String TAG = BoobsAdapter.class.getSimpleName();

    public BoobsAdapter(Context context) {
        super(context, R.layout.boobs_card, new ArrayList<Boobs>());
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "position: " + position);
        BoobsCardBinding binding;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            binding = DataBindingUtil.inflate(inflater, R.layout.boobs_card, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }

        setBoobs(binding, getItem(position));

        return binding.getRoot();
    }

    private void setBoobs(BoobsCardBinding binding, Boobs item) {
        BoobsItemViewModel viewModel = binding.getViewModel();
        if (viewModel == null) {
            viewModel = new BoobsItemViewModel(item);
        } else {
            viewModel.setBoobs(item);
        }
        binding.setViewModel(viewModel);
    }
}