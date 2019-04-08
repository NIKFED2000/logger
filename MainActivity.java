package com.example.logger;

import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button num1;
    Button btnWrite;
    TextView textView;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "найдем View-элементы");
        textView = (TextView) findViewById(R.id.textView);
        num1 = (Button) findViewById(R.id.num1);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.num1:
                        Result();
                        break;
                    case R.id.btnWrite:
                        new Logger();
                        break;
                }
            }
        });


    }
    void Result(){
        try {
            int i = 6/0;
            textView.setText("Result is: " + i);
        } catch (Exception e){
            Log.v(TAG, "Make on zero is not right");
        }
    }
}
