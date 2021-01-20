package com.example.catchthesungerbob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class HowActivity extends AppCompatActivity {

    MediaPlayer mp;
    MediaPlayer mediaPlayer;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how);
    }


    public void clickButtonBack(View view){
        mp = MediaPlayer.create(HowActivity.this, R.raw.clicksound);
        mp.start();
        openHomeActivity();
    }

    public void openHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}