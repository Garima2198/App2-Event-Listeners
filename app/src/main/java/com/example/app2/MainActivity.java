package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3;
    Button btn1, btn2;
    EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.t1);
        btn1 = (Button) findViewById(R.id.b1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText("Button Clicked!");            }
        });
        txt2 = (TextView) findViewById(R.id.t2);
        btn2 = (Button) findViewById(R.id.b2);
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txt2.setText("Long Clicked!");
                return false;
            }
        });

        edit1 = (EditText) findViewById(R.id.et1);
        edit1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b && edit1.getText().toString() != null){
                    Toast.makeText(getApplicationContext(), edit1.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        txt3 = (TextView) findViewById(R.id.t3);
        ImageButton touch = (ImageButton) findViewById(R.id.ib1);

        touch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        txt3.setTextSize(25);
                        return true;
                }
                return false;
            }
        });
    }
}

