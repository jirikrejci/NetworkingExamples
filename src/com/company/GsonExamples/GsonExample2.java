package com.company.GsonExamples;

import com.company.nasserver.NasFileSystem;

/**
 * Created by Jirka on 25.8.2016.
 * Examole with  deserializer
 */
public class GsonExample2 {

    public static void SimpleExample21 () {
        String jsonText = NasFileSystem.readTextFileFromWinFs("C:\\DevFiles\\SimpleExample.json");
        System.out.println(jsonText);


    }




}
