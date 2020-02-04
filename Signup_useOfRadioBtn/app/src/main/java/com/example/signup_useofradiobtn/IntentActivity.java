package com.example.signup_useofradiobtn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IntentActivity extends AppCompatActivity {
    TextView newName,newEmail,newPass,newGen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Intent intent = getIntent();
        String sname = intent.getStringExtra("name");
        String semail = intent.getStringExtra("email");
        String spass = intent.getStringExtra("pass");
        String sgender = intent.getStringExtra("gender");

        newName = (TextView)findViewById(R.id.newName);
        newEmail = (TextView)findViewById(R.id.newEmail);
        newPass = (TextView)findViewById(R.id.newPass);
        newGen = (TextView)findViewById(R.id.newGen);

        newName.setText(sname);
        newEmail.setText(semail);
        newPass.setText(spass);
        newGen.setText(sgender);

    }
}
