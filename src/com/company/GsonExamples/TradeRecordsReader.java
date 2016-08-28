package com.company.GsonExamples;

import com.company.DataStructures.RelevantTradesExch;
import com.company.nasserver.NasFtp;
import com.company.nasserver.ResourcesM;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Jirka on 25.8.2016.
 */
public class TradeRecordsReader {
    public static RelevantTradesExch readTradeRecors () {
        String jsonStr;
        jsonStr = NasFtp.readFileFromFtp("/FilesDB/RelevantTrades.json");  // OK
       //jsonStr = ResourcesM.readResourceToString("/resources/resource_example.json");

        Gson gson = new GsonBuilder().create();
        RelevantTradesExch relevantTradesExch = gson.fromJson(jsonStr, RelevantTradesExch.class);

        System.out.println(relevantTradesExch.toString());
        return relevantTradesExch;
    }
}
