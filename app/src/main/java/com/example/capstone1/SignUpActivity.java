package com.example.capstone1;

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
  private RadioGroup rg;
  private int id;
  private RadioButton rb;



    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference databaseReference = database.getReference("users");

    /*
    private ValueEventListener checkRegister = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
            while(child.hasNext()) {
                if (Phone.getText().toString().equals(child.next().getKey())) {
                    Toast.makeText(getApplicationContext(),"가입된 번호입니다",Toast.LENGTH_LONG).show();
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
           btnSignup = (Button)findViewById(R.id.SignUpButton);
           Phone = (TextView)findViewById(R.id.PhoneID);
           Partner = (TextView)findViewById(R.id.PartnerID);
           Password = (TextView)findViewById(R.id.PW1);
           rg = (RadioGroup)findViewById(R.id.choice);
           id = (int)rg.getCheckedRadioButtonId();
           rb = (RadioButton)findViewById(id);
            databaseReference.child(Phone.getText().toString()).child("비밀번호").setValue(Password.getText().toString());
            databaseReference.child(Phone.getText().toString()).child("파트너").setValue(Partner.getText().toString());
            databaseReference.child(Phone.getText().toString()).child("분류").setValue(rb.getText().toString());
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignup = findViewById(R.id.SignUpButton);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //databaseReference.addListenerForSingleValueEvent(checkRegister);
                Phone = (TextView)findViewById(R.id.PhoneID);
                Partner = (TextView)findViewById(R.id.PartnerID);
                Password = (TextView)findViewById(R.id.PW1);
                rg = (RadioGroup)findViewById(R.id.choice);
                id = (int)rg.getCheckedRadioButtonId();
                rb = (RadioButton)findViewById(id);
                databaseReference.child(Phone.getText().toString()).child("비밀번호").setValue(Password.getText().toString());
                databaseReference.child(Phone.getText().toString()).child("파트너").setValue(Partner.getText().toString());
                databaseReference.child(Phone.getText().toString()).child("분류").setValue(rb.getText().toString());
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
