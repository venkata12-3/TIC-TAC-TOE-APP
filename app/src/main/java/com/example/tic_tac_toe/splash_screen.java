package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class splash_screen extends AppCompatActivity {
    private static int SPLASH_TIMER=4100;
    TextView textView1;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView1=(TextView) findViewById(R.id.textview1);
        textView2=(TextView) findViewById(R.id.textview2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splash_screen.this,Player_Reg.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);
        Animation ani1= AnimationUtils.loadAnimation(splash_screen.this,R.anim.animation);
       textView1.startAnimation(ani1);
       textView2.startAnimation(ani1);

//        Animation ani2= AnimationUtils.loadAnimation(splash_screen.this,R.anim.animation2);
//        textView1.startAnimation(ani2);
//

    }
}