package com.example.birddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextBirdName, editTextZipCode, editTextPersonName;
    Button buttonSubmit, buttonGoTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBirdName = findViewById(R.id.editTextBirdName);
        editTextPersonName = findViewById(R.id.editTextPersonName);
        editTextZipCode = findViewById(R.id.editTextZipCode);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonGoTo = findViewById(R.id.buttonGoTo);

        buttonSubmit.setOnClickListener(this);
        buttonGoTo.setOnClickListener(this);
        //comment

    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Bird");

        if (buttonSubmit == view){

            String submitBirdName = editTextBirdName.getText().toString();
            String submitPersonName = editTextPersonName.getText().toString();
            String temp = editTextZipCode.getText().toString();
            int submitZipCode = Integer.parseInt(temp);

            Bird myBird = new Bird(submitBirdName, submitZipCode, submitPersonName);

            myRef.push().setValue(myBird);





        } else if (buttonGoTo == view){

            Intent mainintent = new Intent(this, SearchActivity.class);
            startActivity(mainintent);

        }

    }
}
