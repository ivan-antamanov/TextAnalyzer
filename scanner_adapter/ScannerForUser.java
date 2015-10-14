package TextAnalyzer.Application.scanner_adapter;

import java.util.*;

/**
 * Created by iantaman on 13.10.2015.
 */
public class ScannerForUser {
    private Scanner scanner;

    public ScannerForUser(Scanner scanner) {
        this.scanner = scanner;
    } //constructor for User using


    public String nextLine() {
        return scanner.nextLine();

    }

    public boolean hasNextLine() {
         return scanner.hasNextLine();
    }


}
