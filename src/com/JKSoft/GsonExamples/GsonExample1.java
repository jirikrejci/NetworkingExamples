package com.JKSoft.GsonExamples;

import com.JKSoft.DataStructures.RelevantTradesExch01;
import com.JKSoft.DataStructures.TradeRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * Created by Jirka on 25.8.2016.
 */
public class GsonExample1 {

    public static void gSonTest1 () {
        Gson gson = new GsonBuilder().create();


        TradeRecord trdRec0 = new TradeRecord ("AUDUSD", 123.71, "buy");
        TradeRecord trdRec1 = new TradeRecord ("GBPUSD", 123.85, "sell");
        TradeRecord trdRec2 = new TradeRecord ("EURUSD", 0.7895, "buy");

        // toJson jednoduchý objekt
        gson.toJson(trdRec0, System.out);


        // to Json Array objektů
        TradeRecord [] trdRecords = new TradeRecord[3];
        trdRecords [0] = trdRec0;
        trdRecords [1] = trdRec1;
        trdRecords [2] = trdRec2;

        System.out.println("\nTraderecords from Array:");
        gson.toJson(trdRecords, System.out);

        // to JSON ArrayList objektů
        ArrayList <TradeRecord> trdRecordsArrayList= new ArrayList<TradeRecord>();
        trdRecordsArrayList.add(trdRec0);
        trdRecordsArrayList.add(trdRec1);
        trdRecordsArrayList.add(trdRec2);

        System.out.println("\nTraderecords from Array List:");
        gson.toJson(trdRecordsArrayList, System.out);


        // to JSON Class s ArrayListem objektů
        RelevantTradesExch01 relevantTradesExch01 = new RelevantTradesExch01();

        relevantTradesExch01.addTradeRecord(trdRec0);
        relevantTradesExch01.addTradeRecord(trdRec1);
        relevantTradesExch01.addTradeRecord(trdRec2);
        relevantTradesExch01.setDatum("25.8.2016");

        relevantTradesExch01.addTradeRecord(trdRec0);

        System.out.println("\nRelevantTradesExchange object - JSON");
        gson.toJson(relevantTradesExch01, System.out);

        // převod JSON na text
        String jsonText;
        jsonText = gson.toJson(relevantTradesExch01, RelevantTradesExch01.class);
        System.out.println("\nTraderecords form Class/Object převedené na String");
        System.out.println(jsonText);

        //*******************  pozor - zpětná konverze **************************************
        //RelevantTradesExch01 inputRecords;
       // gson.fromJson(jsonText, inputRecords);

        RelevantTradesExch01 trdRecords2;
        trdRecords2 = gson.fromJson(jsonText, RelevantTradesExch01.class);
        System.out.println("Po načtení jsonStr zpět na objekt RelevantTradesExch01 - zobrazeno přes toString()");
        System.out.println( trdRecords2);
    }

    public static void gsonTest2 () {
        Gson gson = new GsonBuilder().create();



        TradeRecord trdRec1 = new TradeRecord("USDJPY", 123.21, "buy");
        String jsonStr;

        jsonStr = gson.toJson(trdRec1);
        System.out.println("Json Str1: " + jsonStr);

        TradeRecord trdRec2 = gson.fromJson(jsonStr, TradeRecord.class);
        System.out.println(trdRec2.toString());

    }

}
