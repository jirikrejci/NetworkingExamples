package com.JKSoft.GsonExamples;

import com.JKSoft.DataStructures.RelevantTradesExch;
import com.JKSoft.nasserver.NasFtp;
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
        System.out.println("Json:\n" + JsonConversions.getJSonPretty(relevantTradesExch));
        System.out.println(relevantTradesExch.toString());

        return relevantTradesExch;
    }
}
