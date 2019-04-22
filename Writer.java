package com.example.probe2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Writer {

     public static void writer(Exception ex, String level, String msg){

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;


        try {


            fh = new FileHandler("/storage/emulated/0/LOGTEST/LOGS.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            switch (level){
                case "severe":
                    logger.log(Level.SEVERE, msg, ex);
                    if(!msg.equals(""))
                        logger.severe(msg);
                    break;
                case "info":
                    logger.log(Level.INFO, msg, ex);
                    break;
            }


        } catch (IOException | SecurityException ex1) {
            logger.log(Level.SEVERE, null, ex1);

        }


    }

}
