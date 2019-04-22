package com.example.probe2;

import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnsave;
    Writer r = new Writer();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsave = (Button) findViewById(R.id.btnsave);



        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int j = 20, i = 0;
                try {
                    System.out.println(j/i);
                } catch (ArithmeticException ex) {



                    r.writer(ex,"severe","You can't divide anything by zero");
                    r.writer(ex,"info", "The button SAVE has been pressed");
                }


            }
        });
    }
}
