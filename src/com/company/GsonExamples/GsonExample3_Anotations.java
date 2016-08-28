package com.company.GsonExamples;

import com.company.DataStructures.Box;
import com.company.DataStructures.Boxes;
import com.company.nasserver.ResourcesM;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * Created by Jirka on 27.8.2016.
 */
public class GsonExample3_Anotations {

    public static void simpleExample31 () {

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        String jsonStr;

        Boxes boxes = new Boxes();

        Box box1 = new Box(10, 110, 100, "Box č.1");
        Box box2 = new Box(20, 210, 200, "Box č. 2");
        Box box3 = new Box(30, 310, 300, "Box č. 3");

        boxes.addBox(box1);
        boxes.addBox(box2);
        boxes.addBox(box3);

        gson.toJson(box1, System.out);
        jsonStr = ResourcesM.readResourceToString("/resources/box.json");

        Box box4 = gson.fromJson(jsonStr, Box.class);
        System.out.println("\nBox4 načtený z JSON:" + box4.toString());





        gson.toJson(boxes, System.out);


        jsonStr = ResourcesM.readResourceToString("/resources/boxes.json");
        Boxes boxes2 = gson.fromJson(jsonStr, Boxes.class);

        System.out.println("\nBoxes 2 načtené z JSON:" + boxes2.toString());

        //ArrayList <Box> boxes2 = gson.fromJson(jsonStr, ArrayList.class);



    }




}
