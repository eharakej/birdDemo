package com.example.birddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    }
}
