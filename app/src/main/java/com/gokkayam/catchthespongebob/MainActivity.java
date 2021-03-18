package com.gokkayam.catchthespongebob;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Button btnReset;
    Runnable runnableTime;
    Handler handlerTime;
    Runnable runnableSpeed;
    Handler handlerSpeed;
    TextView txtTime;
    TextView score;
    TextView txtScore,txtTopScore;
    TextView topScore;
    TextView anim00_1Point,anim01_1Point,anim02_1Point,anim10_1Point,anim11_1Point,anim12_1Point,anim20_1Point,anim21_1Point,anim22_1Point;
    TextView anim00_0Point,anim01_0Point,anim02_0Point,anim10_0Point,anim11_0Point,anim12_0Point,anim20_0Point,anim21_0Point,anim22_0Point;
    TextView anim00_2Point,anim01_2Point,anim02_2Point,anim10_2Point,anim11_2Point,anim12_2Point,anim20_2Point,anim21_2Point,anim22_2Point;
    TextView[] anim1Point;
    TextView[] anim0Point;
    TextView[] anim2Point;
    ImageView spongeBob1,spongeBob2,spongeBob3,spongeBob4,spongeBob5,spongeBob6,spongeBob7,spongeBob8,spongeBob9;
    ImageView patrick1,patrick2,patrick3,patrick4,patrick5,patrick6,patrick7,patrick8,patrick9;
    ImageView[] images;
    ImageView hamburger1,hamburger2,hamburger3,hamburger4,hamburger5,hamburger6,hamburger7,hamburger8,hamburger9;
    ImageView bonusImages[];
    int resultScore;
    int time;
    int speed;
    int pointNumber;
    int imageNumber;
    int storedTopScore;
    int possibility;
    int series;
    int seriesTime;
    int bonusRatio;
    int bonusLocation;
    boolean seriesStart;
    boolean stopAnimation;
    Random ran = new Random();
    MediaPlayer mp;
    Intent intent;
    SharedPreferences sharedPreferences;
    Animation animation;
    Animation animationText;
    Animation animationScore;
    Animation animationTopScoreText;
    Animation animationTopScore;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnReset = findViewById(R.id.btnReset);
        txtTime = findViewById(R.id.time);
        score = findViewById(R.id.score);
        txtScore = findViewById(R.id.txtScore);
        topScore = findViewById(R.id.topScore);
        txtTopScore = findViewById(R.id.txtTopScore);
        anim00_1Point = findViewById(R.id.anim00_1Point);
        anim01_1Point = findViewById(R.id.anim01_1Point);
        anim02_1Point = findViewById(R.id.anim02_1Point);
        anim10_1Point = findViewById(R.id.anim10_1Point);
        anim11_1Point = findViewById(R.id.anim11_1Point);
        anim12_1Point = findViewById(R.id.anim12_1Point);
        anim20_1Point = findViewById(R.id.anim20_1Point);
        anim21_1Point = findViewById(R.id.anim21_1Point);
        anim22_1Point = findViewById(R.id.anim22_1Point);
        anim00_0Point = findViewById(R.id.anim00_0Point);
        anim01_0Point = findViewById(R.id.anim01_0Point);
        anim02_0Point = findViewById(R.id.anim02_0Point);
        anim10_0Point = findViewById(R.id.anim10_0Point);
        anim11_0Point = findViewById(R.id.anim11_0Point);
        anim12_0Point = findViewById(R.id.anim12_0Point);
        anim20_0Point = findViewById(R.id.anim20_0Point);
        anim21_0Point = findViewById(R.id.anim21_0Point);
        anim22_0Point = findViewById(R.id.anim22_0Point);
        anim00_2Point = findViewById(R.id.anim00_2Point);
        anim01_2Point = findViewById(R.id.anim01_2Point);
        anim02_2Point = findViewById(R.id.anim02_2Point);
        anim10_2Point = findViewById(R.id.anim10_2Point);
        anim11_2Point = findViewById(R.id.anim11_2Point);
        anim12_2Point = findViewById(R.id.anim12_2Point);
        anim20_2Point = findViewById(R.id.anim20_2Point);
        anim21_2Point = findViewById(R.id.anim21_2Point);
        anim22_2Point = findViewById(R.id.anim22_2Point);
        spongeBob1 = findViewById(R.id.spongeBob1);
        spongeBob2 = findViewById(R.id.spongeBob2);
        spongeBob3 = findViewById(R.id.spongeBob3);
        spongeBob4 = findViewById(R.id.spongeBob4);
        spongeBob5 = findViewById(R.id.spongeBob5);
        spongeBob6 = findViewById(R.id.spongeBob6);
        spongeBob7 = findViewById(R.id.spongeBob7);
        spongeBob8 = findViewById(R.id.spongeBob8);
        spongeBob9 = findViewById(R.id.spongeBob9);
        patrick1 = findViewById(R.id.patrick1);
        patrick2 = findViewById(R.id.patrick2);
        patrick3 = findViewById(R.id.patrick3);
        patrick4 = findViewById(R.id.patrick4);
        patrick5 = findViewById(R.id.patrick5);
        patrick6 = findViewById(R.id.patrick6);
        patrick7 = findViewById(R.id.patrick7);
        patrick8 = findViewById(R.id.patrick8);
        patrick9 = findViewById(R.id.patrick9);
        hamburger1 = findViewById(R.id.hamburger1);
        hamburger2 = findViewById(R.id.hamburger2);
        hamburger3 = findViewById(R.id.hamburger3);
        hamburger4 = findViewById(R.id.hamburger4);
        hamburger5 = findViewById(R.id.hamburger5);
        hamburger6 = findViewById(R.id.hamburger6);
        hamburger7 = findViewById(R.id.hamburger7);
        hamburger8 = findViewById(R.id.hamburger8);
        hamburger9 = findViewById(R.id.hamburger9);
        images = new ImageView[] {spongeBob1,spongeBob2,spongeBob3,spongeBob4,spongeBob5,spongeBob6,spongeBob7,spongeBob8,spongeBob9,
                patrick1,patrick2,patrick3,patrick4,patrick5,patrick6,patrick7,patrick8,patrick9};
        bonusImages = new ImageView[] {hamburger1,hamburger2,hamburger3,hamburger4,hamburger5,hamburger6,hamburger7,hamburger8,hamburger9};
        bonusLocation = 0;
        anim1Point = new TextView[] {anim00_1Point,anim01_1Point,anim02_1Point,
                anim10_1Point,anim11_1Point,anim12_1Point,
                anim20_1Point,anim21_1Point,anim22_1Point};
        anim0Point = new TextView[] {anim00_0Point,anim01_0Point,anim02_0Point,
                anim10_0Point,anim11_0Point,anim12_0Point,
                anim20_0Point,anim21_0Point,anim22_0Point};
        anim2Point = new TextView[] {anim00_2Point,anim01_2Point,anim02_2Point,
                anim10_2Point,anim11_2Point,anim12_2Point,
                anim20_2Point,anim21_2Point,anim22_2Point};
        resultScore=0;
        time=5;
        speed = 900;
        possibility=0;
        pointNumber=0;
        series=0;
        seriesTime=0;
        seriesStart=false;
        stopAnimation=false;
        handlerTime = new Handler();
        handlerSpeed = new Handler();
        imageNumber = ran.nextInt(images.length);

        sharedPreferences=this.getSharedPreferences("com.example.catchthesungerbob", Context.MODE_PRIVATE);
        storedTopScore = sharedPreferences.getInt("storedTopScore",0);
        topScore.setText(""+ storedTopScore);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        animationText = AnimationUtils.loadAnimation(this,R.anim.animscoretext);
        animationScore = AnimationUtils.loadAnimation(this,R.anim.animscore);
        animationTopScoreText = AnimationUtils.loadAnimation(this,R.anim.animtopscoretext);
        animationTopScore = AnimationUtils.loadAnimation(this,R.anim.animtopscore);

        intent = new Intent(MainActivity.this, BackgroundSoundService.class);
        startService(intent);
        mediaPlayer = MediaPlayer.create(this,R.raw.spongebob_music);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        resetGame(btnStart);
        startGame(btnStart);
     }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
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



    @SuppressLint("ClickableViewAccessibility")
    public  void startGame(View button){
        resetPlaying();
        btnStart.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        mp = MediaPlayer.create(MainActivity.this, R.raw.clicksound);
                        mp.start();
                        score.setText(""+0);
                        series=0;
                        if(stopAnimation) {
                            resetAnimations();
                        }
                        startPlaying();
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        runnableTime = new Runnable() {
                            @Override
                            public void run() {
                                txtTime.setText("Time Left : " + time);
                                time--;
                                if(time==0){
                                    txtTime.setText("Time's Up!");
                                    score.setText(""+resultScore);
                                    if(resultScore > storedTopScore) {
                                        sharedPreferences.edit().putInt("storedTopScore", resultScore).apply();
                                        storedTopScore = sharedPreferences.getInt("storedTopScore",0);
                                        topScore.setText("" + storedTopScore);
                                    }
                                    TimeIsUp();
                                    handlerTime.removeCallbacks(runnableTime);
                                    handlerSpeed.removeCallbacks(runnableSpeed);
                                }
                                else {
                                    txtTime.setText("Time Left : " + time);
                                    handlerTime.postDelayed(runnableTime, 1000);
                                }
                            }
                        };
                        handlerTime.post(runnableTime);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        btnStart.setEnabled(false);
                        break;
                    }

                }
                return false;
            }
        });
    }



    @SuppressLint("ClickableViewAccessibility")
    public  void resetGame(View button){
        resetPlaying();
        btnReset.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        mp = MediaPlayer.create(MainActivity.this, R.raw.clicksound);
                        mp.start();
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        resetAnimations();
                        handlerSpeed.removeCallbacks(runnableSpeed);
                        handlerTime.removeCallbacks(runnableTime);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        break;
                    }
                }
                return false;
            }
        });

    }

    public void TimeIsUp(){
        MediaPlayer mp2 = MediaPlayer.create(this, R.raw.spongebob_end);
        mp2.start();
        btnStart.setEnabled(true);
        txtTime.setText("Time's Up!");
        images[imageNumber].setVisibility(View.INVISIBLE);
        time=61;
        speed=900;
        resultScore = 0;
        series=0;
        seriesTime=0;
        seriesStart=false;
        deleteBonus();
        deleteDoubleBonus();
        stopAnimation = true;
        activeAndStartAnimations();
    }

    public void resetPlaying(){
        btnStart.setEnabled(true);
        txtTime.setText("Click Start To Play");
        images[imageNumber].setVisibility(View.INVISIBLE);
        score.setText(""+0);
        time=61;
        speed=900;
        resultScore = 0;
        series=0;
        seriesTime=0;
        seriesStart=false;
        deleteBonus();
        deleteDoubleBonus();
    }

    public void resetAnimations(){
        animationText.setFillAfter(false);
        animationScore.setFillAfter(false);
        animationTopScoreText.setFillAfter(false);
        animationTopScore.setFillAfter(false);
    }

    public void activeAndStartAnimations(){
        animationText.setFillAfter(true);
        animationScore.setFillAfter(true);
        animationTopScoreText.setFillAfter(true);
        animationTopScore.setFillAfter(true);
        txtScore.startAnimation(animationText);
        score.startAnimation(animationScore);
        txtTopScore.startAnimation(animationTopScoreText);
        topScore.startAnimation(animationTopScore);
    }

    public void setBonus(){
        for(int i=0; i<images.length/2; i++){
            images[i].setVisibility(View.VISIBLE);
        }
    }

    public void deleteBonus(){
        for(ImageView image : images){
            image.setVisibility(View.INVISIBLE);
        }
    }

    public void setDoubleBonus(){
        for(int i=0; i<bonusImages.length; i++){
            bonusImages[i].setVisibility(View.VISIBLE);
        }
    }

    public void deleteDoubleBonus(){
        for(ImageView image : bonusImages){
            image.setVisibility(View.INVISIBLE);
        }
    }

    public void startPlaying(){
        runnableSpeed = new Runnable() {
            @Override
            public void run() {
                if(seriesStart){
                    if(seriesTime==0){
                        images[imageNumber].setVisibility(View.INVISIBLE);
                        bonusImages[bonusLocation].setVisibility(View.INVISIBLE);
                    }
                    if(seriesTime==0 && series == 11){
                        setBonus();
                    }
                    if(seriesTime==0 && series == 22){
                        setDoubleBonus();
                        series=0;
                    }
                    seriesTime++;
                    if(seriesTime>4){
                        deleteBonus();
                        deleteDoubleBonus();
                        seriesTime=0;
                        seriesStart=false;
                    }
                    handlerSpeed.postDelayed(runnableSpeed, speed/2);
                }
                else {
                    images[imageNumber].setVisibility(View.INVISIBLE);
                    bonusImages[bonusLocation].setVisibility(View.INVISIBLE);
                    possibility = ran.nextInt(4);
                    if (possibility < 3) {
                        pointNumber = ran.nextInt(images.length / 2);
                        imageNumber = pointNumber;
                    } else {
                        pointNumber = ran.nextInt(images.length / 2);
                        imageNumber = pointNumber + 9;
                    }
                    images[imageNumber].setVisibility(View.VISIBLE);
                    if(resultScore>20){
                        bonusRatio = ran.nextInt(5);
                        bonusLocation = ran.nextInt(bonusImages.length);
                        if(bonusRatio>3 && bonusLocation != imageNumber){
                            bonusImages[bonusLocation].setVisibility(View.VISIBLE);
                        }
                    }
                    handlerSpeed.postDelayed(runnableSpeed, speed);
                }

             }
        };
        handlerSpeed.post(runnableSpeed);
    }

    public void afterClickImage(View view){
        view.setVisibility(View.INVISIBLE);
        MediaPlayer mp2 = MediaPlayer.create(this, R.raw.click_image);
        resultScore = Integer.parseInt(score.getText().toString());
        resultScore++;
        if(!seriesStart) {
            speed = speed - 8;
            series++;
        }
        score.setText(""+resultScore);
        anim1Point[pointNumber].startAnimation(animation);
        mp2.start();
        if(series==10 || series ==21){
            seriesStart=true;
            series++;
        }
    }

    public void afterClickImageNegative(View view){
        view.setVisibility(View.INVISIBLE);
        MediaPlayer mp2 = MediaPlayer.create(this, R.raw.click_image);
        resultScore = Integer.parseInt(score.getText().toString());
        resultScore--;
        score.setText(""+resultScore);
        anim0Point[pointNumber].startAnimation(animation);
        series=0;
        mp2.start();
    }

    public void afterClickImageBonus(View view){
        view.setVisibility(View.INVISIBLE);
        MediaPlayer mp2 = MediaPlayer.create(this, R.raw.click_image);
        resultScore = Integer.parseInt(score.getText().toString());
        resultScore = resultScore + 2;
        score.setText(""+resultScore);
        anim2Point[bonusLocation].startAnimation(animation);
        mp2.start();
    }

    public void clickBob1(View view){
        afterClickImage(view);
    }
    public void clickBob2(View view){
        afterClickImage(view);
    }
    public void clickBob3(View view){
        afterClickImage(view);
    }
    public void clickBob4(View view){
        afterClickImage(view);
    }
    public void clickBob5(View view){
        afterClickImage(view);
    }
    public void clickBob6(View view){
        afterClickImage(view);
    }
    public void clickBob7(View view){
        afterClickImage(view);
    }
    public void clickBob8(View view){
        afterClickImage(view);
    }
    public void clickBob9(View view){
        afterClickImage(view);
    }
    public void clickPatrick1(View view){
        afterClickImageNegative(view);
    }
    public void clickPatrick2(View view){
        afterClickImageNegative(view);
    }
    public void clickPatrick3(View view){
        afterClickImageNegative(view);
    }
    public void clickPatrick4(View view){
        afterClickImageNegative(view);
    }
    public void clickPatrick5(View view){
        afterClickImageNegative(view);
    }
    public void clickPatrick6(View view){
        afterClickImageNegative(view);
    }
    public void clickPatrick7(View view){
        afterClickImageNegative(view);
    }
    public void clickPatrick8(View view){
        afterClickImageNegative(view);
    }
    public void clickPatrick9(View view){
        afterClickImageNegative(view);
    }
    public void clickHamburger1(View view){
        afterClickImageBonus(view);
    }
    public void clickHamburger2(View view){
        afterClickImageBonus(view);
    }
    public void clickHamburger3(View view){
        afterClickImageBonus(view);
    }
    public void clickHamburger4(View view){
        afterClickImageBonus(view);
    }
    public void clickHamburger5(View view){
        afterClickImageBonus(view);
    }
    public void clickHamburger6(View view){
        afterClickImageBonus(view);
    }
    public void clickHamburger7(View view){
        afterClickImageBonus(view);
    }
    public void clickHamburger8(View view){
        afterClickImageBonus(view);
    }
    public void clickHamburger9(View view){
        afterClickImageBonus(view);
    }

}