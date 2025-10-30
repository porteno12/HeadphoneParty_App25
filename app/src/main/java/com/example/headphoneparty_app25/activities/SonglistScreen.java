package com.example.headphoneparty_app25.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.headphoneparty_app25.R;
import com.example.headphoneparty_app25.Song;
import com.example.headphoneparty_app25.SongAdapter;
import com.example.headphoneparty_app25.databinding.ActivityLogInBinding;
import com.example.headphoneparty_app25.databinding.ActivitySonglistScreenBinding;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class SonglistScreen extends AppCompatActivity {
private ActivitySonglistScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySonglistScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Song sng1 = new Song("like a stone",R.drawable.rock,"https://tinyurl.com/4tbz643s" );
        Song sng2 = new Song("pop playlist",R.drawable.pop,"https://tinyurl.com/49nym4ct" );
        Song sng3 = new Song("finding",R.drawable.trance,"https://tinyurl.com/2ju3xdmy" );

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(sng1);
        songs.add(sng2);
        songs.add(sng3);

        SongAdapter adapter = new SongAdapter(songs, SonglistScreen.this);
        binding.lvSongs.setAdapter(adapter);
    }
}