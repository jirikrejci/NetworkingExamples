package com.JKSoft.GeneralClasses;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Jirka on 27.8.2016.
 */
public class PropertyManager {
    public static void writePropertiesTest () {
        java.util.Properties properties = new java.util.Properties();
        properties.setProperty("rok", "2016");
        properties.setProperty("vzkaz", "Ahoj Jirko");
        properties.setProperty("db.jmeno", "Adam");
        properties.setProperty("db.prijmeni", "Bernau");

        FileWriter writer = null;

        try {
            writer = new FileWriter ("test_conf.properties");
            properties.store(writer, "Autor: Jiri Krejci");   // uložení properties včetně komentáře
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {   // pokud nebyl writer uzavřen provedeme pokus o uzavření
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readPropertiesTest (){
        try {
            //FileReader reader = new FileReader("com/JKSoft/nasserver/db.properties");
            FileReader reader = new FileReader("test_conf.properties");
            java.util.Properties properties = new java.util.Properties();
            properties.load(reader);
            String jmeno = properties.getProperty("db.jmeno");
            String prijmeni = properties.getProperty("db.prijmeni");
            System.out.println("jmeno = " + jmeno);
            System.out.println("prijmeni = " + prijmeni);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readProperty (String propertyName){
        FileReader reader = null;
        String outputStr = null;
        try {
            //FileReader reader = new FileReader("com/JKSoft/nasserver/db.properties");
            reader = new FileReader("config.properties");
            java.util.Properties properties = new java.util.Properties();
            properties.load(reader);
            outputStr = properties.getProperty(propertyName);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return outputStr;
    }

    public static void writeProperty (String key, String value){
        FileWriter writer = null;
        String outputStr = null;
        try {
            java.util.Properties properties = new java.util.Properties();
            properties.setProperty(key, value);

            writer = new FileWriter("config.properties");
            properties.store(writer, "no comment");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void showTestsAll () {
        PropertyManager.writePropertiesTest();
        PropertyManager.readPropertiesTest();
        PropertyManager.writeProperty("vzkaz", "Do not panic!!!");
        System.out.println("Vzkaz:" +  PropertyManager.readProperty("vzkaz"));
    }
}




