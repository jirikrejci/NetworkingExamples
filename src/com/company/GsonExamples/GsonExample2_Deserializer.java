package com.company.GsonExamples;

import com.company.DataStructures.Book;
import com.company.JsonDeserializers.BookDeserializer;
import com.company.nasserver.NasFileSystem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Jirka on 25.8.2016.
 * Examole with  JSON deserializer
 */
public class GsonExample2_Deserializer {

    public static void SimpleExample21 () {
        String jsonText = NasFileSystem.readTextFileFromWinFs("C:\\DevFiles\\SimpleExample.json");
        System.out.println(jsonText);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Book.class, new BookDeserializer());   // redistrace Deserializéru
        Gson gson = gsonBuilder.create();

        Book book = gson.fromJson(jsonText, Book.class);
        System.out.println(book);
    }
}
