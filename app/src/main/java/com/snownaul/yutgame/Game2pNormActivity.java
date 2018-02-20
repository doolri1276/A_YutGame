package com.snownaul.yutgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class Game2pNormActivity extends AppCompatActivity {
    int turn;
    final static int TURN_RED =1;
    final static int TURN_BLUE =2;

    boolean[] yut;
    Random rnd;
    final static int DO=1;
    final static int GAE=2;
    final static int GUL=3;
    final static int YUT=4;
    final static int MO=5;
    final static int BACKDO=-1;

    ArrayList<Integer> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2p_norm);
        rnd=new Random();
        turn=rnd.nextInt(2)+1;
        yut=new boolean[4];

        results=new ArrayList<>();

    }

    public void throwYut(){
        int cnt=0;
        for(int i=0; i<yut.length;i++){
            int n=rnd.nextInt(10);
            if(n<4)yut[i]=true;
            else yut[i]=false;

            if(yut[i])cnt++;
        }

        switch (cnt){
            case 0:
                results.add(MO);
                throwYut();
                break;
            case 1:
                if(rnd.nextInt(4)==0)results.add(BACKDO);
                else results.add(DO);
                break;
            case 2:
                results.add(GAE);
                break;
            case 3:
                results.add(GUL);
                break;
            case 4:
                results.add(YUT);
                throwYut();
                break;

        }
    }
}
