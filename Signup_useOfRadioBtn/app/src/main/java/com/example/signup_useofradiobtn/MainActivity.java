package com.example.signup_useofradiobtn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,pass,name;
    RadioButton r1,r2,r3;
    Button signUp;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          signUp = (Button)findViewById(R.id.signUp);
          email = (EditText)findViewById(R.id.newEmail);
          pass = (EditText)findViewById(R.id.pass);
          name = (EditText)findViewById(R.id.newName);

        r1 = (RadioButton)findViewById(R.id.maler);
        r2 = (RadioButton)findViewById(R.id.femr);
        r3 = (RadioButton)findViewById(R.id.othr);

        rg = (RadioGroup)findViewById(R.id.rg);



       signUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String gender = "";
               int i = rg.getCheckedRadioButtonId();
               RadioButton rb =(RadioButton)rg.findViewById(i);
               final String nm = name.getText().toString();
               final String em = email.getText().toString();
               final String ps = pass.getText().toString();
               final String gn = rb.getText().toString();



               //Toast.makeText(MainActivity.this,nm + " your email-id is " + em + " and Password is " + ps + "\nYou are " + gn , Toast.LENGTH_LONG).show();

               Intent intent = new Intent(MainActivity.this,IntentActivity.class);
               intent.putExtra("name",nm);
               intent.putExtra("email",em);
               intent.putExtra("gender",gn);
               intent.putExtra("pass",ps);

                if(em.equals("rohitkmails@gmail.com")) {
                    if(ps.equals("123456")) {
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "ERROR!\n"+ nm +" please enter your valid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "ERROR!\n"+ nm +" please enter your valid email or password", Toast.LENGTH_SHORT).show();
                }

           }
       });



    }
}
