package main.java.TextAnalyzer.impl.utility;

import java.util.Scanner;

/**
 * Created by iantaman on 08.10.2015.
 */
public class Context {

    private String inputText;
    private String filePath;

    public Context() {
    }

    public String getInputText() {
        return inputText;
    }

    public boolean readInputText() {
        this.inputText = new Scanner(System.in).nextLine();
        return checkExit(inputText);
    }

    public void readInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean readFilePath() {
        filePath = new Scanner(System.in).nextLine();
        return checkExit(filePath);
    }

    boolean checkExit(String inputData) {
        if (inputData.equals("exit")) {
            System.out.println("Bay");
            return true;
        }
        return false;
    }

}
