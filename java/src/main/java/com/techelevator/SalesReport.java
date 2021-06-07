package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalesReport {

    File salesReport = new File("SalesReport.txt");
    String salesReportItem = null;




    public void salesReportMethod (String salesReportItem) throws IOException {
        salesReport.createNewFile();

        try (PrintWriter writer = new PrintWriter(new FileWriter(salesReport, true))) {
            this.salesReportItem = salesReportItem;
            writer.println(salesReportItem + "|");
            writer.flush();
        }

    }




}
