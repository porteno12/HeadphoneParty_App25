package com.example.headphoneparty_app25;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.headphoneparty_app25.databinding.ItemSongCardBinding;
import com.example.headphoneparty_app25.databinding.RowSongsBinding;

import java.util.List;

public class SongAdapter extends BaseAdapter {
    private List<Song> songs;
    private Context context;

    public SongAdapter(List<Song> songs, Context context) {
        this.songs = songs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*RowSongsBinding binding = RowSongsBinding.inflate(LayoutInflater.from(context), parent, false);
        View view = binding.getRoot();

        Song temp = songs.get(position);
        binding.tvSongName.setText(temp.getName());

        return view;*/

        ItemSongCardBinding binding = ItemSongCardBinding.inflate(LayoutInflater.from(context), parent, false);
        ;
        View row = binding.getRoot();


        Song s = songs.get(position);
        binding.ivCatIcon.setImageResource(s.getCategoryIcon());
        binding.tvSongTitle.setText(s.getName());
        binding.tvCategory.setText(s.getCategoryName());

        return row;
    }
}
