package com.company.GsonExamples;

import com.company.nasserver.NasFtp;
import com.company.nasserver.ResourcesM;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Jirka on 25.8.2016.
 */
public class TradeRecordsReader {
    public static void readTradeRecors () {
        String jsonStr;
        //jsonStr = NasFtp.readFileFromFtp("/FilesDB/RelevantTradesJSON.txt");  // OK
       jsonStr = ResourcesM.readResourceToString("/resources/resource_example.json");

        Gson gson = new GsonBuilder().create();
        String ahoj = gson.fromJson(jsonStr, String.class);


    }
}
