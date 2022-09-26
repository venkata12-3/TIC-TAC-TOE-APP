package com.example.tic_tac_toe;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.airbnb.lottie.LottieAnimationView;


public class Winning_Message extends Dialog{
     String message;
     MainActivity mainActivity;



    public Winning_Message(@NonNull Context context,String message,MainActivity mainActivity) {

        super(context);
        this.message=message;
        this.mainActivity=mainActivity;
    }

    TextView txt_winner;
    AppCompatButton btn_paly_again;
    AppCompatButton btn_restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_message);

        txt_winner=findViewById(R.id.txt_winner);
        btn_paly_again=findViewById(R.id.btn_play_again);
        btn_restart=findViewById(R.id.btn_restart);

//        lottieAnimationView.findViewById(R.id.winning_animation);

        txt_winner.setText(message);


        btn_paly_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.play_again_match();
                dismiss();


            }
        });

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restart_match();
                dismiss();

            }
        });






    }
}