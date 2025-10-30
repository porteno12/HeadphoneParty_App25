package com.example.headphoneparty_app25.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.headphoneparty_app25.Utils;
import com.example.headphoneparty_app25.databinding.ActivityLogInBinding;

public class LogInActivity extends AppCompatActivity {

    private ActivityLogInBinding binding;
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // init SharedPreferences
        prefs = getSharedPreferences("user_data_sp_file", MODE_PRIVATE);
        restoreData();

        // ----- Sign Up link -----
        binding.tvSignUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
                //startActivity(intent);
                startActivity(new Intent(LogInActivity.this, SignUpActivity.class));
            }
        });

        binding.cbRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // אם מסומן – שמור מיד את מה שיש כרגע בשדה
                    saveUserData();
                } else {
                    // אם בוטל – נקה מה-SharedPreferences
                    prefs.edit().remove(Utils.key_user_name).apply();
                    prefs.edit().remove(Utils.key_password).apply();

                }
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    saveUserData();
            }
        });


    }

    private void restoreData() {
        // ----- Restore saved user if exists -----
        String savedUserName = prefs.getString(Utils.key_user_name, null);
        String savedPassword = prefs.getString(Utils.key_password, null);

        if (prefs == null || savedUserName == null || savedPassword==null)
            Log.d(LogInActivity.class.getSimpleName(),"enter data to save1");
        else if (savedUserName != null ) {
            binding.etUsername.setText(savedUserName);
            binding.etPassword.setText(savedPassword);
            binding.cbRememberMe.setChecked(true);
        } else {
            binding.cbRememberMe.setChecked(false);
        }
    }

    public void saveUserData() {
        boolean remember = binding.cbRememberMe.isChecked();
        String user_name = binding.etUsername.getText().toString().trim();
        String pass = binding.etPassword.getText().toString().trim();

        if(user_name.length()==0 || pass.length()==0)
            Toast.makeText(this, "enter data to save", Toast.LENGTH_SHORT).show();
        else if (remember) {
            prefs.edit().putString("username", user_name).apply();
            prefs.edit().putString(Utils.key_password, pass).apply();
        } else if (!remember) {
            // אם לא מסומן – נקה
            prefs.edit().remove(Utils.key_user_name).apply();
            prefs.edit().remove(Utils.key_password).apply();
        }
    }
}
