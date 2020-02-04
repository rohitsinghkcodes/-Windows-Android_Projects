package com.example.galaryexp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton prev, next;
    ImageView pic;
    TextView text;
    int currentImage=0;
    //0-1-2-3-0-1-2-3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void prev(View view){
       String idx = "pic" + currentImage;
       int x = this.getResources().getIdentifier(idx,"id",getPackageName());
       pic = findViewById(x);
       pic.setAlpha(0f);
        currentImage = (4 + currentImage-1)%4;
        String idy = "pic" + currentImage;
        int y = this.getResources().getIdentifier(idx,"id",getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);
    }
    public void next(View view){
        String idx = "pic" + currentImage;
        int x = this.getResources().getIdentifier(idx,"id",getPackageName());
        pic = findViewById(x);
        pic.setAlpha(0f);
        currentImage = (currentImage+1)%4;
        String idy = "pic" + currentImage;
        int y = this.getResources().getIdentifier(idx,"id",getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);
    }

}
