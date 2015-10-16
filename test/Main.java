package main.java.TextAnalyzer.test;

import main.java.TextAnalyzer.impl.scanner_adapter.ScannerForUser;
import main.java.TextAnalyzer.impl.service_tool.ConsoleCommands;

/**
 * Created by iantaman on 15.10.2015.
 */
public class Main {
    public static void main(String[] args) {

        ScannerForUser scannerForTest = new ScannerForTest("src\\main\\java\\TextAnalyzer\\resources\\new 3.txt", "be");
        ConsoleCommands consoleCommands = new ConsoleCommands(scannerForTest);

        consoleCommands.scanningProcess();
    }
}
