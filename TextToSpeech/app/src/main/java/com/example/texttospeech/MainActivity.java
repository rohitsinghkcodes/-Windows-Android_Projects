package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech mTTs;
    private EditText mEditText;
    private SeekBar mSeekBarPitch;
    private SeekBar mSeekBarSpeed;
    private Button mButtonSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonSpeak = findViewById(R.id.button_speak);
        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
              if(status == TextToSpeech.SUCCESS){
                  int result = mTTs.setLanguage(Locale.getDefault());

                  if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                      Log.e("TTS", "Language Not Supported");
                  }else{
                      mButtonSpeak.setEnabled(true);
                  }
              }else{
                  Log.e("TTS", "Initialisation Failed");
              }
            }
        });

        mEditText = findViewById(R.id.edit_text);
        mSeekBarPitch = findViewById(R.id.seek_bar_pitch);
        mSeekBarSpeed = findViewById(R.id.seek_bar_speed);

        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }
        });
    }
    private void speak(){
        String text = mEditText.getText().toString();
        float pitch =(float) mSeekBarPitch.getProgress()/50;
        if(pitch<0.1) pitch = 0.1f;
        float speed =(float) mSeekBarSpeed.getProgress()/50;
        if(speed<0.1) speed = 0.1f;

        mTTs.setPitch(pitch);
        mTTs.setSpeechRate(speed);

        mTTs.speak(text, TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    protected void onDestroy() {
        if(mTTs != null){
            mTTs.stop();
            mTTs.shutdown();
        }
        super.onDestroy();
    }
}
