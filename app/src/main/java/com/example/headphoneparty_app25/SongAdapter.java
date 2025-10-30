package com.example.headphoneparty_app25;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
        RowSongsBinding binding;

        // 1. בדיקת מיחזור: האם יש View קיים להשתמש בו?
        if (convertView == null) {
            // אם לא, ניצור View חדש *בצורה הנכונה*
            // אנחנו מעבירים את ה-inflater, ה-parent, ו-false
            binding = RowSongsBinding.inflate(LayoutInflater.from(context), parent, false);

            // נשמור את ה-binding ב-Tag של ה-View לשימוש עתידי (במיחזור)
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            // אם כן, נשלוף את ה-binding הקיים מה-Tag
            binding = (RowSongsBinding) convertView.getTag();
        }

        // 2. קבלת הנתונים לפריט הנוכחי
        Song temp = songs.get(position);

        // 3. הצגת הנתונים באמצעות ה-binding
        binding.tvSongName.setText(temp.getName());

        // (אם היו לך עוד שדות, היית מעדכן גם אותם)
        // לדוגמה: binding.tvArtistName.setText(temp.getArtist());

        // 4. החזרת ה-View המעודכן
        return convertView;
    }
}
