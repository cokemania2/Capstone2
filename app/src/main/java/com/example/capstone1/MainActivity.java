package com.example.capstone1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstone1.MenuActivity;
import com.example.capstone1.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("Name");
        String PName = intent.getStringExtra("PName");

        TextView textView = findViewById(R.id.Parentinfo);
        textView.setText("사용자 이름 : "+Name+"파트너 이름 :"+PName);

        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ManagementActivity.class);
                intent.putExtra("name","학생관리");
                startActivity(intent);

            }
        });
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                intent.putExtra("name","미션관리");
                startActivity(intent);

                finish();

            }
        });
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ManagementActivity.class);
                intent.putExtra("name","용돈관리");
                startActivity(intent);

                finish();

            }
        });
    }

}
