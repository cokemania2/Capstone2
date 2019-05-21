package com.example.capstone1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class SignUpActivity extends AppCompatActivity {


  private Button btnSignup;
  private TextView Phone;
  private TextView Partner;
  private TextView Password;
  private RadioButton rb;
  private RadioGroup rg;


    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference databaseReference = database.getReference("users");


    private ValueEventListener checkRegister = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
            while(child.hasNext()) {
                if (Phone.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    databaseReference.removeEventListener(this);
                    return;
                }
                if (Phone.getText().toString().equals(child.next().getKey())) {
                    Toast.makeText(getApplicationContext(),"가입된 번호입니다",Toast.LENGTH_LONG).show();
                    databaseReference.removeEventListener(this);
                    return;
                }
                if (Password.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    databaseReference.removeEventListener(this);
                    return;
                }
                if (Password.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    databaseReference.removeEventListener(this);
                    return;
                }

            }
            makeNewId();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };


    void makeNewId() {
            final String value = ((RadioButton)findViewById(rg.getCheckedRadioButtonId() )).getText().toString();
            databaseReference.child(Phone.getText().toString()).child("분류").setValue(value);
            databaseReference.child(Phone.getText().toString()).child("비밀번호").setValue(Password.getText().toString());
            databaseReference.child(Phone.getText().toString()).child("파트너").setValue(Partner.getText().toString());

            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
              intent.putExtra("PhoneNumber",Phone.getText().toString());
              startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignup = findViewById(R.id.SignUpButton);
        btnSignup = (Button)findViewById(R.id.SignUpButton);
        Phone = (TextView)findViewById(R.id.PhoneID);
        Partner = (TextView)findViewById(R.id.PartnerID);
        Password = (TextView)findViewById(R.id.PW1);
        rg = (RadioGroup) findViewById(R.id.choice);
        rb = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.addListenerForSingleValueEvent(checkRegister);

            }
        });

    }
}
