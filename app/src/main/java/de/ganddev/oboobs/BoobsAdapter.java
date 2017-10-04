package de.ganddev.oboobs;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Collections;
import java.util.List;

import de.ganddev.oboobs.data.Boobs;
import de.ganddev.oboobs.databinding.BoobsCardBinding;

/**
 * Created by bjornahlfeld on 29.09.17.
 */

public class BoobsAdapter extends BaseAdapter {

    private List<Boobs> items;

    public BoobsAdapter() {
        items = Collections.emptyList();
    }

    public BoobsAdapter(List<Boobs> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Boobs getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BoobsCardBinding binding;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            binding = DataBindingUtil.inflate(inflater, R.layout.boobs_card, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }

        setBoobs(binding, items.get(position));

        return binding.getRoot();
    }

    public void setItems(@NonNull List<Boobs> items) {
        this.items = items;
    }

    private void setBoobs(BoobsCardBinding binding, Boobs item) {
        BoobsItemViewModel viewModel = binding.getViewModel();
        if(viewModel == null) {
            viewModel = new BoobsItemViewModel(item);
            binding.setViewModel(viewModel);
        } else {
            viewModel.setBoobs(item);
        }
    }
}