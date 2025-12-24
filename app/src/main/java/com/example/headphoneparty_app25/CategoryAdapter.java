package com.example.headphoneparty_app25;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.headphoneparty_app25.databinding.ItemCategorySpinnerBinding;

public class CategoryAdapter extends BaseAdapter {
    private final Context context;
    private final String[] categories;
    private final int[] categoryIcons;
    private final LayoutInflater inflater;

    public CategoryAdapter(Context context, String[] categories, int[] categoryIcons) {
        this.context = context;
        this.categories = categories;
        this.categoryIcons = categoryIcons;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return categories.length; }

    @Override
    public Object getItem(int position) { return categories[position]; }

    @Override
    public long getItemId(int position) { return position; }

    public View getView(int position, View convertView, ViewGroup parent) {
        ItemCategorySpinnerBinding binding = ItemCategorySpinnerBinding.inflate(inflater, parent, false);;
        View row = row = binding.getRoot();

        binding.ivCatIcon.setImageResource(categoryIcons[position]);
        binding.tvCatName.setText(categories[position]);
        return row;
    }


}
