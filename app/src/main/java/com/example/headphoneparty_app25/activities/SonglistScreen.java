package com.example.headphoneparty_app25.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.headphoneparty_app25.R;
import com.example.headphoneparty_app25.Song;
import com.example.headphoneparty_app25.SongAdapter;
import com.example.headphoneparty_app25.Utils;
import com.example.headphoneparty_app25.databinding.ActivityLogInBinding;
import com.example.headphoneparty_app25.databinding.ActivitySonglistScreenBinding;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class SonglistScreen extends AppCompatActivity {
    private ActivitySonglistScreenBinding binding;
    private ArrayList<Song> songs;
    private SongAdapter adapter;

    private ActivityResultLauncher<Intent> addSongLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySonglistScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Register Activity Result launcher (modern API)
        addSongLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Intent data = result.getData();
                            String name = data.getStringExtra(Utils.EXTRA_NAME);
                            String url = data.getStringExtra(Utils.EXTRA_URL);
                            String category = data.getStringExtra(Utils.EXTRA_CATEGORY_NAME);
                            int iconRes = data.getIntExtra(Utils.EXTRA_CATEGORY_ICON, 0);

                            if (name != null && url != null && category != null && iconRes != 0) {
                                // FIX: use the same constructor signature as the seeded items
                                songs.add(new Song(name, iconRes, url));
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SonglistScreen.this,
                                        "Added: " + name + " (" + category + ")", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );

        // Seed data (unchanged)
        Song sng1 = new Song("like a stone", R.drawable.rock, "https://tinyurl.com/4tbz643s");
        Song sng2 = new Song("pop playlist", R.drawable.pop, "https://tinyurl.com/49nym4ct");
        Song sng3 = new Song("finding", R.drawable.trance, "https://tinyurl.com/2ju3xdmy");

        songs = new ArrayList<Song>();
        songs.add(sng1);
        songs.add(sng2);
        songs.add(sng3);

        adapter = new SongAdapter(songs, SonglistScreen.this);
        binding.lvSongs.setAdapter(adapter);

        // Open song on click
        binding.lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song s = songs.get(position);
                if (s != null && s.getUrl() != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(s.getUrl()));
                    startActivity(intent);
                }
            }
        });

        binding.lvSongs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Song removed = songs.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(SonglistScreen.this, "Removed: " + removed.getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        // Add new song → open AddSongScreen via ActivityResultLauncher
        binding.fbAddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(SonglistScreen.this, AddSongScreen.class);
                addSongLauncher.launch(add);
            }
        });
    }
}
