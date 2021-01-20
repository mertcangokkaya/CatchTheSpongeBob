package com.example.catchthesungerbob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    MediaPlayer mp;
    MediaPlayer mediaPlayer;
    Intent intent;
    ImageView menuPlay;
    ImageView menuHowtoplay;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        menuPlay = findViewById(R.id.menuPlay);
        menuHowtoplay = findViewById(R.id.menuHowtoplay);
        animation = AnimationUtils.loadAnimation(this,R.anim.animmenu);
        menuPlay.startAnimation(animation);
        menuHowtoplay.startAnimation(animation);
        intent = new Intent(HomeActivity.this, HomeBackgroundSoundService.class);
        startService(intent);
        //mediaPlayer = MediaPlayer.create(this,R.raw.spongebob_home_music);
        //mediaPlayer.start();
    }

    @Override
    public void onPause(){
        stopService(intent);
        super.onPause();
    }

    @Override
    protected void onResume() {
        startService(intent);
        super.onResume();
    }

    public void clickPlay(View view){
        mp = MediaPlayer.create(HomeActivity.this, R.raw.clicksound);
        mp.start();
        //mediaPlayer.pause();
        openMainActivity();
    }

    public void clickHowtoplay(View view){
        mp = MediaPlayer.create(HomeActivity.this, R.raw.clicksound);
        mp.start();
        openHowActivity();
    }

    public void clickSq(View view){
        mp = MediaPlayer.create(HomeActivity.this, R.raw.sq_sound);
        mp.start();
    }

    public void openMainActivity(){
        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void openHowActivity(){
        Intent intent = new Intent(this, HowActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}