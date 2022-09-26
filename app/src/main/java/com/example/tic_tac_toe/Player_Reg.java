package com.example.tic_tac_toe;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Player_Reg extends AppCompatActivity {

    Button btstartgame;
    EditText etplayer1;
    EditText etplayer2;
    LinearLayout et_ly1;
    LinearLayout et_ly2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_reg);

        btstartgame=(Button) findViewById(R.id.btstartgame);
        etplayer1=(EditText) findViewById(R.id.etp1);
        etplayer2=(EditText) findViewById(R.id.etp2);
        et_ly1=(LinearLayout) findViewById(R.id.et_ly1);
        et_ly2=(LinearLayout) findViewById(R.id.et_ly2);





        btstartgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String player1=etplayer1.getText().toString();
                final String player2=etplayer2.getText().toString();
                if(player1.length()>7||player2.length()>7){
                    Toast.makeText(Player_Reg.this, "player names never exceed more than 7 characters", Toast.LENGTH_SHORT).show();
                }
               else if (player1.isEmpty() || player2.isEmpty()) {
                    Toast.makeText(Player_Reg.this, "Please enter players names", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Player_Reg.this, MainActivity.class);
                    intent.putExtra("player1", player1);
                    intent.putExtra("player2", player2);
                    startActivity(intent);
                }

            }
        });


    }
}