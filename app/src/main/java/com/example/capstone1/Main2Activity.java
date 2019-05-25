package com.example.capstone1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String Name = intent.getStringExtra("Name");
        String PName = intent.getStringExtra("PName");
        textView = (TextView)findViewById(R.id.textView8);
        textView.setText(Name);
    }
}
