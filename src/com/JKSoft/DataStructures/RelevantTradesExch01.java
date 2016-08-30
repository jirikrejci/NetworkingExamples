package com.JKSoft.DataStructures;

import java.util.ArrayList;

/**
 * Created by Jirka on 25.8.2016.
 */

public class RelevantTradesExch01 {

    private String datum = "xxxdatum";
    ArrayList<TradeRecord> tradeRecords = new ArrayList<TradeRecord>();

    public void addTradeRecord (TradeRecord tradeRecord) {
        tradeRecords.add(tradeRecord);
    }

    // getters and setters
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        StringBuffer output_str = new StringBuffer(300);
        output_str.append(super.toString() + "\n");
        output_str.append(datum.toString() + "  \n");
        for (TradeRecord trdRec: tradeRecords) {
            output_str.append(trdRec.toString() + "\n");
        }
        return output_str.toString();
    }
}
