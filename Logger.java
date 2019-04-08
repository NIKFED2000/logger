package com.example.logger;

import android.os.Environment;
import java.io.FileWriter;
import android.util.Log;
import java.io.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    final String Filename_SD = "Log_File";
    final String DIR_SD = "LastLogs";
    final String LOG_TAG = "Log";
  void Log() {
      if (!Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)) {
          Log.v(LOG_TAG, "SD-card is not aviable: " + Environment.getExternalStorageState());
                  return;
      }
      try {
          File sdPath = Environment.getExternalStorageDirectory();
          sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
          sdPath.mkdirs();
          File sdFile = new File(sdPath, Filename_SD);
          InputStreamReader inputStreamReader = new InputStreamReader(System.in);
          BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
          BufferedWriter log = new BufferedWriter(new FileWriter(sdFile));
          String line;
          while(!(line = bufferedReader.readLine()).equals("exit")){
              log.write(line);
          }
          bufferedReader.close();
          log.close();
      } catch (Exception e) {
          e.printStackTrace();
      }

  }

}

