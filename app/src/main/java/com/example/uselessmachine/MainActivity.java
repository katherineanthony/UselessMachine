package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch switchy;
    private Button buttonSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
    }

    private void wireWidgets()
    {
        switchy = findViewById(R.id.switch_main_useless);
        buttonSD = findViewById(R.id.button_main_selfDestruct);
    }

    private void setListeners()
    {
        switchy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, final boolean isChecked) {

                if(isChecked) {
                    new CountDownTimer(2000, 10) {
                        @Override
                        public void onTick(long l) {
                            if(!switchy.isChecked())
                            {
                                cancel();
                            }
                        }

                        @Override
                        public void onFinish() {
                            switchy.setChecked(false);
                        }
                    }.start();
                }

//                if(isChecked){
////                    Toast.makeText(MainActivity.this, "toasty", Toast.LENGTH_SHORT).show();
////                }
////                    else{
////                    Toast.makeText(MainActivity.this, "not toasty", Toast.LENGTH_SHORT).show();
////                    }
            }
        });

    }
}
