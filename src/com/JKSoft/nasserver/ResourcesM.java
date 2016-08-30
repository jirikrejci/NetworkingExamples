package com.JKSoft.nasserver;

import com.JKSoft.MainTrida;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Jirka on 27.8.2016.
 */
public class ResourcesM {

    public static String readResourceToString(String resourceName) {

        InputStream inputStream = MainTrida.class.getResourceAsStream(resourceName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder strBuff = new StringBuilder(1024);
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                strBuff.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  strBuff.toString();
    }



}
