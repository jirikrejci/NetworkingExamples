package com.company.DataStructures;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Jirka on 27.8.2016.
 */
public class Boxes {
    @SerializedName ("boxes")
    private ArrayList <Box> boxes = new ArrayList<Box>();

    public void addBox (Box box) {
        boxes.add(box);
    }

    @Override
    public String toString() {
        return "Boxes{" +
                "boxes=" + boxes +
                '}';
    }
}
