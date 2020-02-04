package com.example.support;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class splashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        Logolauncher logolauncher=new Logolauncher();
        logolauncher.start();
    }

    private class Logolauncher extends Thread{
        public void run(){
            try{
                sleep(1000);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent=new Intent(splashScreen.this,MainActivity.class);
            startActivity(intent);
            splashScreen.this.finish();
        }
    }
}
