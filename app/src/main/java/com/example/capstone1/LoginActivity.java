package com.example.capstone1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class LoginActivity extends AppCompatActivity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference databaseReference = database.getReference("users");
    /*
    final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;
    */
    private TextView Phone;
    private TextView Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, (GoogleApiClient.OnConnectionFailedListener) this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        ImageButton conn_btn = (ImageButton)findViewById(R.id.FirebaseButton);

        conn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent();
                startActivityForResult(signInIntent,RC_SIGN_IN);
            }
        });
        */

        Button LoginButton = findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Phone = (TextView)findViewById(R.id.userPhone);
                Password = (TextView)findViewById(R.id.userPassword);

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
                        while (child.hasNext()) {
                            if (child.next().getKey().equals(Phone.getText().toString())) {
                                Toast.makeText(getApplicationContext(), "로그인!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "존재하지 않는 아이디입니다.", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
        Button SignUpButton = findViewById(R.id.SignUpButton);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
