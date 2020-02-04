package com.example.rohittube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView sampleVideo = findViewById(R.id.sampleVideo);
         sampleVideo.setVideoPath("android.resources://" + getPackageName() + "/" + R.drawable.77);
    }
}
