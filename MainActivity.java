package com.example.test;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String Filename_SD = "Log_File";
    final String DIR_SD = "LastLogs";
    TextView textView;
    Button num1;
    Button save;
    private static final String TAG = "myLogs";
    Logger r = new Logger();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "найдем View-элементы");
        textView = (TextView) findViewById(R.id.textView);
        num1 = (Button) findViewById(R.id.num1);
        save = (Button) findViewById(R.id.save);




        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int i = 6 / 0;
                    textView.setText("Результат деления = " + i);
                } catch (Exception e) {
                    Log.v(TAG, "Делить на 0 нельзя!", e);
                }
            }

        });
        save.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        textView.setText("Нажата кнопка save");
        Log.v(TAG, "Обработаем нажатие кнопки 2");
        logger();


    }
    public void logger(){
        if (!Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)) {
            Log.v(TAG, "SD-card is not aviable: " + Environment.getExternalStorageState());
            return;
        }

        try {
            File sdPath = Environment.getExternalStorageDirectory();
            sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
            sdPath.mkdirs();
            File sdFile = new File(sdPath, Filename_SD);
            BufferedWriter log = new BufferedWriter(new FileWriter(sdFile));

            log.write("somemasse");
            log.close();


            Log.v(TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
