package com.example.birddemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextZipCodeSearch;
    Button buttonSearch, buttonGoToReport;
    TextView textViewBirdName, textViewPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editTextZipCodeSearch = findViewById(R.id.editTextZipCodeSearch);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonGoToReport = findViewById(R.id.buttonGoToReport);
        textViewBirdName = findViewById(R.id.textViewBirdName);
        textViewPersonName = findViewById(R.id.textViewPersonName);

        buttonSearch.setOnClickListener(this);
        buttonGoToReport.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Bird");

        if (buttonSearch == view) {


            String temp = editTextZipCodeSearch.getText().toString();
            int searchZipCode = Integer.parseInt(temp);


            myRef.orderByChild("zipcode").equalTo(searchZipCode).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    Bird foundBird = dataSnapshot.getValue(Bird.class);
                    String findBirdName = foundBird.birdname;
                    String findPersonName = foundBird.personname;
                    Toast.makeText(SearchActivity.this, "this is working", Toast.LENGTH_SHORT).show();

                    textViewBirdName.setText(findBirdName);
                    textViewPersonName.setText(findPersonName);


                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {


                }
            });


        } else if (buttonGoToReport == view){

            Intent secondaryintent = new Intent(this, MainActivity.class);
            startActivity(secondaryintent);

        }

    }
}
