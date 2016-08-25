package com.company.nasserver;


import java.io.*;
import java.net.*;


/**
 * Created by Jirka on 25.8.2016.
 */
public class NasFileSystem extends NasGeneral

{

    public static String readTextFileFromWinFs(String filename) {
        try {
            InputStream inputStream = new FileInputStream(filename);
            String outputStr = readStreamToString(inputStream);
            return (outputStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return(e.toString());
        }
    }


    public static void writeTextToFileWinFs (String filename, String textToWrite) {
        File file = new File(filename);
        try {
            OutputStream outputStream = new FileOutputStream(filename);
            writeStringToStream(outputStream,textToWrite);
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static void readTextFileFromFileSystem2 (String path) {
        try {
            URL url = new URL ("file:\\\\" + path);
            InputStream inputStream = url.openStream();
            String outputStr = readStreamToString(inputStream);
            System.out.println("Výpis načteného souboru:");
            System.out.println(outputStr);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }













}

// windows new File("\\\\server\\path\\to\\file.txt")







