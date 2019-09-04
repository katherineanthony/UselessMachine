package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch switchy;
    private Button buttonSD;
    private ConstraintLayout constraintLayout;
    private ProgressBar progressy;
    private TextView textViewy;
    private Button busylookin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressy.setVisibility(View.INVISIBLE);
        textViewy.setVisibility(View.INVISIBLE);

        wireWidgets();
        setListeners();
    }

    private void wireWidgets()
    {
        switchy = findViewById(R.id.switch_main_useless);
        buttonSD = findViewById(R.id.button_main_selfDestruct);
        constraintLayout = findViewById(R.id.constraintLayout_main_layout);
        progressy = findViewById(R.id.progressBar_main_load);
        textViewy = findViewById(R.id.textView_main_lookBusy);
        busylookin = findViewById(R.id.button_main_lookBusy);
    }

    private void setListeners()
    {
        switchy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                               @Override
                                               public void onCheckedChanged(CompoundButton compoundButton, final boolean isChecked) {

                                                   if (isChecked) {
                                                       new CountDownTimer(2000, 10) {
                                                           @Override
                                                           public void onTick(long l) {
                                                               if (!switchy.isChecked()) {
                                                                   cancel();
                                                               }
                                                           }

                                                           @Override
                                                           public void onFinish() {
                                                               switchy.setChecked(false);
                                                           }
                                                       }.start();
                                                   }
                                               }
                                           });
        buttonSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                    new CountDownTimer(10000, 1000) {
                        int x = 10;

                        @Override
                        public void onTick(long l) {
                            x--;
                            buttonSD.setText(String.valueOf(x));
                            int r = 200 - (10 * x);

                            int color = Color.rgb(r, 0, 0);

                            constraintLayout.setBackgroundColor(color);

                        }

                        @Override
                        public void onFinish() {
                            finish();
                        }
                    }.start();

                }
        });
        busylookin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busylookin.setVisibility(View.INVISIBLE);
                new CountDownTimer(30000, 1000) {
                    @Override
                    public void onTick(long l) {

                        int oldProgress = 0;
                        while(progressy.getProgress() < 500) {
                            progressy.setProgress(oldProgress);
                            textViewy.setText(oldProgress + "%");
                            oldProgress += 2;

                        }
                    }

                    @Override
                    public void onFinish() {
                        finish();
                    }
                }.start();

            }

        });

    }
}
