package com.example.headphoneparty_app25.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.headphoneparty_app25.CategoryAdapter;
import com.example.headphoneparty_app25.R;
import com.example.headphoneparty_app25.Utils;
import com.example.headphoneparty_app25.databinding.ActivityAddSongScreenBinding;

public class AddSongScreen extends AppCompatActivity {
    private ActivityAddSongScreenBinding binding;

    // Category names and matching icons (keep names consistent with your project)
    private final String[] categories = new String[] { "Pop", "Rock", "Trance" };
    private final int[] categoryIcons = new int[] {
            R.drawable.pop,
            R.drawable.rock,
            R.drawable.trance
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddSongScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Use your separate CategoryAdapter (icon + text)
        CategoryAdapter categoryAdapter = new CategoryAdapter(
                AddSongScreen.this,
                categories,
                categoryIcons
        );
        binding.spCategory.setAdapter(categoryAdapter);
        // Save → validate inputs, pack result, and finish with RESULT_OK
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.etSongName.getText() != null
                        ? binding.etSongName.getText().toString().trim() : "";
                String url = binding.etSongUrl.getText() != null
                        ? binding.etSongUrl.getText().toString().trim() : "";
                int pos = binding.spCategory.getSelectedItemPosition();

                if (TextUtils.isEmpty(name)) {
                    binding.etSongName.setError("Song name is required");
                    return;
                }
                if (TextUtils.isEmpty(url)) {
                    binding.etSongUrl.setError("URL is required");
                    return;
                }
                if (!url.startsWith("http")) {
                    binding.etSongUrl.setError("URL must start with http/https");
                    return;
                }
                if (pos < 0 || pos >= categories.length) {
                    // defensive guard; shouldn't happen with a proper adapter
                    return;
                }

                Intent result = new Intent();
                result.putExtra(Utils.EXTRA_NAME, name);
                result.putExtra(Utils.EXTRA_URL, url);
                result.putExtra(Utils.EXTRA_CATEGORY_NAME, categories[pos]);
                result.putExtra(Utils.EXTRA_CATEGORY_ICON, categoryIcons[pos]);

                setResult(RESULT_OK, result);
                finish();
            }
        });

        // Cancel → just finish with RESULT_CANCELED
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
