package com.company;

import com.company.GeneralClasses.PropertyManager;
import com.company.GsonExamples.GsonExample1;
import com.company.GsonExamples.GsonExample2_Deserializer;
import com.company.GsonExamples.GsonExample3_Anotations;
import com.company.GsonExamples.TradeRecordsReader;
import com.company.nasserver.ResourcesM;

import java.io.*;
import java.net.*;

public class Main {
    public static final String URL_ZENTITY_LIBRARY = "http://www.lukaspetrik.cz/filemanager/tmp/reader/data.xml";
    public static final String FILE_NAME_LOCAL_RELEVANT_TRADES_JSON = "c:/DevFiles/RelevantTradesJSON.txt";
   // public static final String sURL = "http://www.seznam.cz/index.html";

    // **********************************************
    // Testy Http Url Connection
    // **********************************************


    public static void testHttpUrlConnection(){

        URL url = null;
        try {
        url = new URL(URL_ZENTITY_LIBRARY);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println(con.getResponseCode());
        System.out.println(con.getContentType());
        System.out.println(con.getConnectTimeout());
        System.out.println(con.getContent().toString());
        System.out.println(con.getResponseMessage().toString());

                } catch (MalformedURLException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    public static void testReadXmlFileFromHttp (){
        URL url = null;
        int responseCode;
        try {
            url = new URL(URL_ZENTITY_LIBRARY);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            System.out.println(responseCode = con.getResponseCode());
            if (responseCode != 200) {
                System.out.println("Response code not 200 OK - exiting function");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer strBuffer = new StringBuffer(1000);
            String line;
            while ((line = br.readLine()) != null) {
                strBuffer.append(line);
            }

            String output = strBuffer.toString();
            System.out.println("Přijatý soubor:");
            System.out.print(output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        String inputStr;

        //***************** file connections testing *************************************

       // testHttpUrlConnection();
       // testReadXmlFileFromHttp();
       // NasWeb.readTextFileFromWeb("http://www.lukaspetrik.cz/filemanager/tmp/reader/data.xml");


       //NasFileSystem.readTextFileFromWinFs("c:/DevFiles/RelevantTradesJSON.txt");   // OK

       // NasFileSystem.readTextFileFromWinFs("file://c:/DevFiles/RelevantTradesJSON.txt");
       // NasFileSystem.readTextFileFromWinFs("R:/RelevantTradesJSON.txt");
    //
// s tímhle pracujeme        //  inputStr = NasFtp.readFileFromFtp("/FilesDB/RelevantTradesJSON.txt");  // OK
        // NasFtp.writeStringToFtp("/FilesDB/WrittenTextFile.txt", "Ahoj, tohle je soubor zapsaný přes FTP");


        //System.out.println("Načtený soubor:");
        //System.out.println(inputStr);



        //NasFileSystem.readTextFileFromFileSystem2("NASSERVER1\\volume1\\FilesDB\\RelevantTradesJSON.txt");
       // NasFileSystem.writeTextToFileWinFs("c:/DevFiles/WrittenFile.txt", "Aho jirko, tohle je zapsaný text");

        //************************   Gson testing *******************************************
      //  GsonExample1.gSonTest1();   // working
       // GsonExample2_Deserializer.SimpleExample21();     // working
       // TradeRecordsReader.readTradeRecors();  // waiting
        GsonExample3_Anotations.simpleExample31();



//    PropertyManager.showTestsAll();   working
        //jsonStr = ResourcesM.readResourceToString("/resources/resource_example.json");

    }


}
