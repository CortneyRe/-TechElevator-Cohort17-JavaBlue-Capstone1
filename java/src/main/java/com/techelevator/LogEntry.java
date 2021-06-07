package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogEntry {
    //private PrintWriter out; commented this out because I believe we don't need it.


    File logFile = new File("LogFile.txt");
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss a ");
    String action = null;
    BigDecimal transactionBalance = null; //we need transactionBalance to show us the money the user added as $-.-- instead of $- with no decimal places on line 31
    BigDecimal machineBalance = null;

    public void logEntryMethod(String action, BigDecimal transactionalBalance, BigDecimal machineBalance) throws IOException {
        logFile.createNewFile();
        Calendar calobj = Calendar.getInstance();

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))){
            this.action = action;
            this.transactionBalance = transactionalBalance;
            this.machineBalance = machineBalance;
            writer.println(dateFormat.format(calobj.getTime()) + action + ": $" + transactionBalance + " $" + machineBalance); //doesn't show the amount the user added as $-.--, but instead as $- , which doesn't meet the terms of the README
            writer.flush();

        }
    }
}