package com.example.headphoneparty_app25;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.headphoneparty_app25.databinding.ActivityListOfFffBinding;
import com.example.headphoneparty_app25.databinding.ActivitySonglistScreenBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListOfFFF extends AppCompatActivity {
    private ActivityListOfFffBinding binding;
    private ArrayList<Song> songs;

    private DatabaseReference songsRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListOfFffBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //songs =new ArrayList<>();
        Song sng1 = new Song("up up ", R.drawable.pop, "https://youtu.be/yebNIHKAC4A?si=8DsEb7-AcM8wyFuo");
/*
        songsRef = FirebaseDatabase.getInstance().getReference("songsList").push();
        Log.d("firebase",songsRef.getKey());
        Log.d("firebase", "id:"+sng1.getId());
        sng1.setId(songsRef.getKey());
        Log.d("firebase",sng1.getId() );
        Song sng2 = new Song("up up ", R.drawable.pop, "https://youtu.be/yebNIHKAC4A?si=8DsEb7-AcM8wyFuo");
        songsRef = FirebaseDatabase.getInstance().getReference("songsList").push();
        sng2.setId(songsRef.getKey());
        Log.d("firebase",sng2.getId());*/



/*
        songsRef.child(sng1.getId()).setValue(sng1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                    Toast.makeText(ListOfFFF.this, "successfully added", Toast.LENGTH_SHORT).show();
            }
        });*/
        /*Song sng3 = new Song("up up ", R.drawable.pop, "https://youtu.be/yebNIHKAC4A?si=8DsEb7-AcM8wyFuo");
        Song sng4 = new Song("up up ", R.drawable.pop, "https://youtu.be/yebNIHKAC4A?si=8DsEb7-AcM8wyFuo");

        songs.add(sng1);
        songs.add(sng2);
        songs.add(sng3);
        songs.add(sng4);


        String email = binding.etEmail.getText().toString().trim();
        if (email.isEmpty() || !email.contains("@")) {
            binding.tilEmail.setError("נא להזין כתובת אימייל תקינה");
        } else {
            binding.tilEmail.setError(null); // הסרת השגיאה
        }
*/
    }
}