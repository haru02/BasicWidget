package com.kimhyojung.android.basicwidget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //결과값이 출력되는 텍스트뷰
    TextView tv;
    // 라디오그룹
    RadioGroup rg;
    // 체크박스
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    //스위치
    Switch sw;
    // 토글
    ToggleButton tb;
    // 프로그래스바
    ProgressBar pb;
    Switch sw2;
    //탐색바
    SeekBar sb;
    // 탐색바의 값을 입력바든 View
    TextView sb_tv;

    RatingBar rb;
    TextView rb_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv = (TextView) findViewById(R.id.textView2);

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 현재 체크된 라이오버튼 아이디를 가져온다
                // int check = rg.getCheckedRadioButtonId();
                Intent intent = null;
                switch(checkedId){
                    case R.id.radioApple:
                        tv.setText("Apple이 선택됨");
                        intent = new Intent(MainActivity.this, TabActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.radioOrange:
                        tv.setText("Orange 선택됨");
                        intent = new Intent(MainActivity.this, DateActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.radioBanana:
                        tv.setText("Banana가 선택됨");
                        intent = new Intent(MainActivity.this, TextActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        cb1 = (CheckBox) findViewById(R.id.dogCheckBox);
        cb2 = (CheckBox) findViewById(R.id.pigCheckBox);
        cb3 = (CheckBox) findViewById(R.id.chickenCheckBox);
        cb1.setOnCheckedChangeListener(checkedChangeListener);
        cb2.setOnCheckedChangeListener(checkedChangeListener);
        cb3.setOnCheckedChangeListener(checkedChangeListener);

        sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                if(view.isChecked()){
                    view.setText("스위치가 On 되었습니다");
                } else {
                    view.setText("스위치 Off");
                }
            }
        });

        tb = (ToggleButton) findViewById(R.id.toggleButton);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    buttonView.setText("스위치가 On 되었습니다");
                    tb.setText("ON");
                } else {
                    buttonView.setText("스위치 Off");
                    tb.setText("OFF");
                }
            }
        });

        pb = (ProgressBar) findViewById(R.id.progressBar);
        sw2 = (Switch) findViewById(R.id.switch2);

        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                if(view.isChecked()){
                    view.setText("스위치가 On 되었습니다");
                    pb.setVisibility(View.VISIBLE);
                } else {
                    view.setText("스위치 Off");
                    pb.setVisibility(View.INVISIBLE);
                }
            }
        });

        sb = (SeekBar) findViewById(R.id.seekBar);
        sb_tv = (TextView) findViewById(R.id.textView5);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_tv.setText(progress+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, seekBar.getProgress()+" 위치에서 터치가 시작됨", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, seekBar.getProgress()+" 위치에서 터치가 종료됨", Toast.LENGTH_SHORT).show();
            }
        });

        rb = (RatingBar) findViewById(R.id.ratingBar);
        rb_tv = (TextView) findViewById(R.id.textView11);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rb_tv.setText(rating+"/5");
            }
        });


    }



    // 컴파운드 계열(체크박스, 토글, 스위치 등) 버튼에서 사용되는 체크별화를 감지하는 리스너
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            StringBuilder sb = new StringBuilder();

            if(cb1.isChecked()){
                sb.append("Dog, ");
            }if(cb2.isChecked()){
                sb.append("Pig, ");
            }if(cb3.isChecked()){
                sb.append("Chicken");
            }
            tv.setText(sb.toString());
        }
    }; // 변수임

}
