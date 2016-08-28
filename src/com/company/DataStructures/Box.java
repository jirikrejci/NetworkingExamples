package com.company.DataStructures;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jirka on 27.8.2016.
 */
public class Box {
    @SerializedName("box width")
    private int width;

    @SerializedName("box height")
    private int height;

    @SerializedName("box depth")
    private int depth;

    @SerializedName("box label")
    private String label;
    // methods removed for brevity


    public Box(int width, int height, int depth, String label) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.label = label;
    }



    @Override
    public String toString() {
        return "Box{" +
                "label=" + label +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}
