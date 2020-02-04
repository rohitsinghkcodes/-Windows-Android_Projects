package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MSG="com.rohitcode.order.Order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void placeOrder(View view){
        //Here we will handle place order button
        //      INTENT
        Intent intent=new Intent(this,OrderActivity.class);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5= findViewById(R.id.editText5);
        EditText editText6= findViewById(R.id.editText6);
        String message = "Your order for " + editText6.getText().toString() + ", " +
                editText5.getText().toString() + ", " + editText4.getText().toString() + ", "
                + editText3.getText().toString() + " & " + editText2.getText().toString() +
                " is placed successfully";
        intent.putExtra(MSG,message);
        startActivity(intent);

    }
}
