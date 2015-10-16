package main.java.TextAnalyzer.impl;

import main.java.TextAnalyzer.impl.scanner_adapter.ScannerForUser;
import main.java.TextAnalyzer.impl.service_tool.ConsoleCommands;

import java.util.Scanner;

/**
 * Created by iantaman on 24.09.2015.
 */
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        ScannerForUser scannerForTest = new ScannerForUser(scanner);
        ConsoleCommands consoleCommands = new ConsoleCommands(scannerForTest);

       while(!consoleCommands.scanningProcess());


    }
}
