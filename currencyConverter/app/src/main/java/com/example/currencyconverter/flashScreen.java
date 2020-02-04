package com.example.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class flashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash_screen);
        getSupportActionBar().hide();
        logoLauncher logoLauncher =new logoLauncher();
        logoLauncher.start();

    }
    private class logoLauncher extends Thread{
        public void run(){
            try{
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent=new Intent(flashScreen.this,MainActivity.class);
            startActivity(intent);
            flashScreen.this.finish();
        }
    }
}