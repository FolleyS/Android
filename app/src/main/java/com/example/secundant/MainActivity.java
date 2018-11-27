package com.example.secundant;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTimer();
    }

    public void onClickStart(View view) {
        running=true;
    }

    public void onClickStop(View view) {
        running=false;
    }

    public void onClickReset(View view) {
        running=false;
        seconds=0;
    }

    private void runTimer(){
        final TextView textView=(TextView) findViewById(R.id.time_view);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/360;
                int minutes= (seconds%3600)/60;
                int second=seconds%60;

                String time=String.format("%d:%02d:%02d", hours, minutes, second );
                textView.setText(time);
                if(running){
                    second++;
                }
                handler.postDelayed(this, 1000);
            }
        });

    }
}
