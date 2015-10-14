package TextAnalyzer.Application;

import TextAnalyzer.Application.scanner_adapter.ScannerForTest;
import TextAnalyzer.Application.scanner_adapter.ScannerForUser;
import TextAnalyzer.Application.service.ConsoleCommands;
import TextAnalyzer.Application.service.TextAnalyzerUtils;

import java.util.Scanner;

/**
 * Created by iantaman on 24.09.2015.
 */
public class Main {
    public static void main(String[] args) {

        TextAnalyzerUtils text = new TextAnalyzerUtils();
        Scanner scanner = new Scanner(System.in);
        ScannerForUser scannerForUser = new ScannerForUser(scanner);
        ScannerForUser scannerForTest = new ScannerForTest("C:\\Users\\iantaman\\Desktop\\new 1.txt","and");
        ConsoleCommands consoleCommands = new ConsoleCommands(scannerForTest);

        consoleCommands.scanningProcessChoosen();


    }
}
