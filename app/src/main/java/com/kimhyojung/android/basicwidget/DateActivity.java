package com.kimhyojung.android.basicwidget;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class DateActivity extends AppCompatActivity {

    Chronometer timer;
    Button start;
    Button stop;
    Button pause;
    // 현재 일시정지 버튼이 눌렸는지 체크
    boolean pauseflag = false;
    long pausetime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        timer = (Chronometer) findViewById(R.id.chronometer);
        start = (Button) findViewById(R.id.startbutton);
        stop = (Button) findViewById(R.id.stopbutton);
        pause = (Button) findViewById(R.id.pausebutton);

        start.setOnClickListener(onClickListener);
        stop.setOnClickListener(onClickListener);
        pause.setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {



            switch(v.getId()){
                case R.id.startbutton:
                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.start();
                    break;
                case R.id.stopbutton :
                    timer.stop();
                    break;
                case R.id.pausebutton :
                    if(pauseflag) {
                        long now = SystemClock.elapsedRealtime();
                        long gap = now -pausetime;
                        timer.setBase(timer.getBase()+gap);
                        timer.start();

                        pause.setText("Start");
                        pauseflag=false;
                        break;
                    } else {
                        pausetime = SystemClock.elapsedRealtime();
                        timer.stop();
                        pause.setText("Restart");
                        pauseflag=true;
                    }

            }
        }
    };


}
