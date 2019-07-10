package com.example.poc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Family_Prasadam_Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family__prasadam__registration);

        String UserName = getIntent().getExtras().getString("UserName");

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText("Hare Krishna "+UserName);
        setContentView(textView);
    }
}
