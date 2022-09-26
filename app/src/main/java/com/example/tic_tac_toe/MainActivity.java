package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView player1_name;
    TextView player2_name;

    LinearLayout player1_layout;
    LinearLayout player2_layout;

    ImageView row1_1;
    ImageView row1_2;
    ImageView row1_3;
    ImageView row2_1;
    ImageView row2_2;
    ImageView row2_3;
    ImageView row3_1;
    ImageView row3_2;
    ImageView row3_3;

    List<int[]> matrix_list=new ArrayList<>();

    private int[] box_pos={0,0,0,0,0,0,0,0,0};

    int player_turn=1;
    int selected_box=1;



    //String getplayer1_name=getIntent().getStringExtra("player1");
    //String getplayer2_name=getIntent().getStringExtra("player2");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1_name=(TextView) findViewById(R.id.player1_name);
        player2_name=(TextView) findViewById(R.id.player2_name);

        player1_layout=(LinearLayout) findViewById(R.id.player1_layout);
        player2_layout=(LinearLayout) findViewById(R.id.player2_layout);


        player1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player1_layout.setBackgroundResource(R.drawable.colour1);
                player2_layout.setBackgroundResource(R.drawable.colour2_1);

            }
        });

        player2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player2_layout.setBackgroundResource(R.drawable.colour1);
                player1_layout.setBackgroundResource(R.drawable.colour2_1);
                player_turn=2;
            }
        });

        row1_1=(ImageView) findViewById(R.id.row1_1);
        row1_2=(ImageView) findViewById(R.id.row1_2);
        row1_3=(ImageView) findViewById(R.id.row1_3);
        row2_1=(ImageView) findViewById(R.id.row2_1);
        row2_2=(ImageView) findViewById(R.id.row2_2);
        row2_3=(ImageView) findViewById(R.id.row2_3);
        row3_1=(ImageView) findViewById(R.id.row3_1);
        row3_2=(ImageView) findViewById(R.id.row3_2);
        row3_3=(ImageView) findViewById(R.id.row3_3);

        String getplayer1_name=getIntent().getStringExtra("player1");
        String getplayer2_name=getIntent().getStringExtra("player2");

        player1_name.setText(getplayer1_name);
        player2_name.setText(getplayer2_name);

        // for rows
        matrix_list.add(new int[]{0,1,2});
        matrix_list.add(new int[]{3,4,5});
        matrix_list.add(new int[]{6,7,8});
        // for columns
        matrix_list.add(new int[]{0,3,6});
        matrix_list.add(new int[]{1,4,7});
        matrix_list.add(new int[]{2,5,8});
        // for diagonal
        matrix_list.add(new int[]{0,4,8});
        matrix_list.add(new int[]{2,4,6});

        row1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbox_selected(0)){
                    action((ImageView)view,0);
                }

            }
        });

        row1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbox_selected(1)){
                    action((ImageView)view,1);
                }

            }
        });

        row1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbox_selected(2)){
                    action((ImageView)view,2);
                }

            }
        });

        row2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbox_selected(3)){
                    action((ImageView)view,3);
                }

            }
        });

        row2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbox_selected(4)){
                    action((ImageView)view,4);
                }

            }
        });

        row2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbox_selected(5)){
                    action((ImageView)view,5);
                }

            }
        });

        row3_1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(isbox_selected(6)){
                    action((ImageView)view,6);
                }

            }
        });

        row3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbox_selected(7)){
                    action((ImageView)view,7);
                }

            }
        });

        row3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbox_selected(8)){
                    action((ImageView)view,8);

                }

            }
        });


        
    }// 0 1 2    3 4 5    1 0 0 0 0 0 0 0 0

    public void action(ImageView imageView,int cell_index){
        box_pos[cell_index]=player_turn;// b[0]=1   b[3]=2  b[1]=1
        if(player_turn==1){
            imageView.setImageResource(R.drawable.cross);
            if(check_winner()){
                Winning_Message winning_message=new Winning_Message(MainActivity.this,player1_name.getText().toString()+" won the match",MainActivity.this);
                winning_message.setCancelable(false);
                winning_message.show();
            }else if(selected_box==9){
                Winning_Message winning_message=new Winning_Message(MainActivity.this,"it is a draw",MainActivity.this);
                winning_message.setCancelable(false);
                winning_message.show();
            }else{
                change_player_turn(2);
                selected_box++;
            }
        }
        else {  // 1 0 0    1 0 0    0 0 0

            imageView.setImageResource(R.drawable.img_1);
            if(check_winner()){
                Winning_Message winning_message=new Winning_Message(MainActivity.this,player2_name.getText().toString()+" won the match",MainActivity.this);
                winning_message.setCancelable(false);
                winning_message.show();

            }else if(selected_box==9){
                Winning_Message winning_message=new Winning_Message(MainActivity.this,"it is a draw",MainActivity.this);
                winning_message.setCancelable(false);
                winning_message.show();

            }else{
                change_player_turn(1);  //
                selected_box++;

            }
        }



    }

    public void change_player_turn(int current_player)
    {
        player_turn=current_player;
        if(player_turn==1){
            player1_layout.setBackgroundResource(R.drawable.colour1);
            player2_layout.setBackgroundResource(R.drawable.colour2_1);

        }else{
            player2_layout.setBackgroundResource(R.drawable.colour1);
            player1_layout.setBackgroundResource(R.drawable.colour2_1);
        }

    }

    public boolean check_winner(){
        boolean res=false;

        for(int i=0;i<matrix_list.size();i++){
            int win[]=matrix_list.get(i);
            if(box_pos[win[0]]==player_turn
                    &&box_pos[win[1]]==player_turn
                    &&box_pos[win[2]]==player_turn){
                return true;
            }
        }
        return false;
    }


    public boolean isbox_selected(int pos){

        return box_pos[pos]==0?true:false;
    }

    public void play_again_match()
    {

        String str1=getIntent().getStringExtra("player1");
        String str2=getIntent().getStringExtra("player2");
        Intent intent1=new Intent(MainActivity.this,MainActivity.class);
        intent1.putExtra("player1", str1);
        intent1.putExtra("player2", str2);
        startActivity(intent1);
        finish();
//        int box_pos[]=new int[]{0,0,0,0,0,0,0,0,0};
//        player_turn=1;
//        selected_box=1;
//        row1_1.setImageResource(R.drawable.cell_back);
//        row1_2.setImageResource(R.drawable.cell_back);
//        row1_3.setImageResource(R.drawable.cell_back);
//        row2_1.setImageResource(R.drawable.cell_back);
//        row2_2.setImageResource(R.drawable.cell_back);
//        row2_3.setImageResource(R.drawable.cell_back);
//        row3_1.setImageResource(R.drawable.cell_back);
//        row3_2.setImageResource(R.drawable.cell_back);
//        row3_3.setImageResource(R.drawable.cell_back);

    }

    public void restart_match()
    {
        Intent intent2=new Intent(MainActivity.this,Player_Reg.class);
        startActivity(intent2);
        finish();
    }


}