package com.example.android.uamp;

import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by grantg on 10/9/16.
 */

public class LyricsDisplay {
    public static ArrayList<Integer> endTimes;

    public static ArrayList<String> getLyrics(String song) {
        ArrayList<String> lyrics = new ArrayList<String>();
        String line;
        song += ".txt";
        //song = "George Michael - Careless Whisper (Lyrics).txt"; //Remove

        try {
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            path.mkdirs();
            File lyricsFile = new File(path, song);
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(lyricsFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> items = new ArrayList<String>();

            int lineNum = 1;
            int endTimeIndex = 0;
            endTimes = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                if (lineNum == 1) {
                    String[] rawEndTimes = line.split(",");

                    for (int i = 0; i < rawEndTimes.length; i++) {
                        int timeToAdd = Integer.parseInt(rawEndTimes[i]);
                        endTimes.add(timeToAdd);
                    }
                }
                else {
                    lyrics.add(line);
                }
                lineNum++;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            song + "'");
            lyrics.add("No lyrics loaded");
            lyrics.add("Default lyrics");
            lyrics.add("For testing purposes");
            lyrics.add("They should be removed for deployment");
            lyrics.add("No lyrics loaded");
            lyrics.add("Default lyrics");
            lyrics.add("For testing purposes");
            lyrics.add("They should be removed for deployment");
            lyrics.add("No lyrics loaded");
            lyrics.add("Default lyrics");
            lyrics.add("For testing purposes");
            lyrics.add("They should be removed for deployment");
            lyrics.add("No lyrics loaded");
            lyrics.add("Default lyrics");
            lyrics.add("For testing purposes");
            lyrics.add("They should be removed for deployment");
            lyrics.add("No lyrics loaded");
            lyrics.add("Default lyrics");
            lyrics.add("For testing purposes");
            lyrics.add("They should be removed for deployment");


        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + song + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        return lyrics;
    }
}
