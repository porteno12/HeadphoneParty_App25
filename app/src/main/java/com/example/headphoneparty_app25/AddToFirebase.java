package com.example.headphoneparty_app25;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.headphoneparty_app25.databinding.ActivityAddToFirebaseBinding;
import com.example.headphoneparty_app25.databinding.ActivityListOfFffBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddToFirebase extends AppCompatActivity {
    private ActivityAddToFirebaseBinding binding;

    private DatabaseReference songsRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddToFirebaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Song sng1 = new Song("up up ", R.drawable.pop, "https://youtu.be/yebNIHKAC4A?si=8DsEb7-AcM8wyFuo");

        //connecting to the list of songs and adding a new node to put isite the song that will be added
        songsRef = FirebaseDatabase.getInstance().getReference("songs").push();
        Log.d("firebase", songsRef.getKey());
        sng1.setId(songsRef.getKey());  //updating the song id to be the node id in firebase
        //adding to firebase
        songsRef.child(sng1.getId()).setValue(sng1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                    Toast.makeText(AddToFirebase.this,
                            "adding was successfull", Toast.LENGTH_SHORT).show();
            }
        });
    }
}